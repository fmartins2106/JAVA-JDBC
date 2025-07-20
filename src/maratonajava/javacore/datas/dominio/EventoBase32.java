package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida32;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase32;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase32;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class EventoBase32 implements Agendavel32{
    private String nomeEvento;
    private String localEvento;
    private ZonedDateTime dataHora;

    public EventoBase32(String nomeEvento, String localEvento, ZonedDateTime dataHora) {
        setNomeEvento(nomeEvento);
        setLocalEvento(localEvento);
        setDataHora(dataHora);
    }

    public static void validacaoNomeEvento(String nomeEvento){
        if (nomeEvento == null || nomeEvento.isEmpty() || !nomeEvento.matches("^[\\p{all}0-9]+( [\\p{all}0-9]+)*$")){
            throw new NomeEventoBase32();
        }
    }

    public static void validacaoLocalEvento(String localEvento){
        if (localEvento == null || localEvento.isEmpty() || !localEvento.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new LocalEventoBase32();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoDataHora(ZonedDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraInvalida32();
        }
    }

    public void setNomeEvento(String nomeEvento) {
        validacaoNomeEvento(nomeEvento);
        this.nomeEvento = formatoString(nomeEvento);
    }

    public void setLocalEvento(String localEvento) {
        validacaoLocalEvento(localEvento);
        this.localEvento = formatoString(localEvento);
    }

    public void setDataHora(ZonedDateTime dataHora) {
        validacaoDataHora(dataHora);
        this.dataHora = dataHora;
    }

    @Override
    public boolean estarNoFuturo() {
        return dataHora.isAfter(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
    }

    public String getDataCompleta(){
        return dataHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(new Locale("pt","BR")));
    }

    @Override
    public void reagendar(int dias) {
        LocalDateTime dataHora = this.dataHora.toLocalDateTime().plusDays(dias);
        ZonedDateTime novaDataHora = ZonedDateTime.of(dataHora,this.dataHora.getZone());
        if (novaDataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            System.out.println("Data ou hora inválida.");
            return;
        }
        setDataHora(novaDataHora);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome evento:"+nomeEvento);
        System.out.println("Local evento:"+localEvento);
        System.out.println("Data completa:"+getDataCompleta());
        System.out.println("Está no futuro ?:"+(estarNoFuturo() ? "Sim." : "Não."));
    }
}
