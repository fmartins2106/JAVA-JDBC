package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida33;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase32;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase33;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class EventoBase33 implements Agendavel33{
    protected String nomeEvento;
    protected String localEvento;
    protected ZonedDateTime dataHoraEvento;

    public EventoBase33(String nomeEvento, String localEvento, ZonedDateTime dataHoraEvento) {
        setNomeEvento(nomeEvento);
        setLocalEvento(localEvento);
        setDataHoraEvento(dataHoraEvento);
    }

    public static void validacaoNomeEvento(String nomeEvento){
        if (nomeEvento == null || nomeEvento.isEmpty() || !nomeEvento.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeEventoBase33();
        }
    }

    public static void validacaoLocalEvento(String localEvento){
        if (localEvento == null || localEvento.isEmpty() || !localEvento.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new LocalEventoBase32();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoDataHoraEvento(ZonedDateTime dataHoraEvento){
        if (dataHoraEvento == null || dataHoraEvento.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraInvalida33();
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

    public void setDataHoraEvento(ZonedDateTime dataHoraEvento) {
        validacaoDataHoraEvento(dataHoraEvento);
        this.dataHoraEvento = dataHoraEvento;
    }

    @Override
    public boolean estarNoFuturo() {
        return dataHoraEvento.isAfter(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
    }

    public String getDataCompleta(){
        return dataHoraEvento.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(new Locale("pt","BR")));
    }

    @Override
    public void reagendar(int dias) {
        LocalDateTime dataHora = this.dataHoraEvento.toLocalDateTime().plusDays(dias);
        ZonedDateTime novaDataHora = ZonedDateTime.of(dataHora,this.dataHoraEvento.getZone());
        if (novaDataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            System.out.println("Data ou hora inválida.");
            return;
        }
        setDataHoraEvento(novaDataHora);
        System.out.println("Evento reagendado com sucesso.");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome do evento:"+nomeEvento);
        System.out.println("Local do evento:"+localEvento);
        System.out.println("Data completa:"+getDataCompleta());
        System.out.println("Está no futuro? (sim | não):"+(estarNoFuturo() ? "Sim." : "Não."));
    }
}
