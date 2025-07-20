package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida36;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase36;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase36;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class EventoBase36 implements Agendavel36{
    protected String nomeEvento;
    protected String localEvento;
    protected ZonedDateTime dataHora;

    public EventoBase36(String nomeEvento, String localEvento, ZonedDateTime dataHora) {
        this.nomeEvento = nomeEvento;
        this.localEvento = localEvento;
        dataHora = dataHora;
    }

    public static void validacaoNomeEvento(String nomeEvento){
        if (nomeEvento == null || nomeEvento.isEmpty() || !nomeEvento.matches("^[\\p{all}0-9,]+( [\\p{all}0-9,]+)*$")){
            throw new NomeEventoBase36();
        }
    }

    public static void validacaoLocalEvento(String localEvento){
        if (localEvento == null || localEvento.isEmpty() || !localEvento.matches("^[\\p{L}0-9,]+( [\\p{L}0-9,]+)*$")){
            throw new LocalEventoBase36();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoDataHoraEvento(ZonedDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraInvalida36();
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
        validacaoDataHoraEvento(dataHora);
        dataHora = dataHora;
    }

    @Override
    public boolean estaNoFuturo() {
        return dataHora.isAfter(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
    }

    @Override
    public void reagendar(int dias) {
        LocalDateTime dataHora = this.dataHora.toLocalDateTime().plusDays(dias);
        ZonedDateTime novaDataHora = ZonedDateTime.of(dataHora,this.dataHora.getZone());
        try {
            validacaoDataHoraEvento(novaDataHora);
            setDataHora(novaDataHora);
            System.out.println("Evento reagendado com sucesso.");
        }catch (DataHoraInvalida36 e){
            System.out.println(e.getMessage());
        }
    }

    public String getDataCompleta(){
        return dataHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(new Locale("pt","BR")));
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome evento:"+this.nomeEvento);
        System.out.println("Local evento:"+this.localEvento);
        System.out.println("Data completa:"+getDataCompleta());
        System.out.println("Está no futuro ?(sim | não):"+(estaNoFuturo() ? "Sim" : "Não"));
    }
}
