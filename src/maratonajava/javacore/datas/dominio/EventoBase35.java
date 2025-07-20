package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida35;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase35;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase35;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class EventoBase35 implements Agendavel35{
    private String nomeEvento;
    private String localEvento;
    private ZonedDateTime dataHora;

    public EventoBase35(String nomeEvento, String localEvento, ZonedDateTime dataHora) {
        this.nomeEvento = nomeEvento;
        this.localEvento = localEvento;
        this.dataHora = dataHora;
    }

    public static void validacaoNomeEvento(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9,]+( [\\p{L}0-9,]+)*$")){
            throw new NomeEventoBase35();
        }
    }

    public static void validacaoLocalEvento(String localEvento){
        if (localEvento == null ||  localEvento.isEmpty() || !localEvento.matches("^[\\p{L}0-9,]+( [\\p{L}0-9,]+)*$")){
            throw new LocalEventoBase35();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoDataHora(ZonedDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraInvalida35();
        }
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        validacaoNomeEvento(nomeEvento);
        this.nomeEvento = formatoString(nomeEvento);
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        validacaoLocalEvento(localEvento);
        this.localEvento = formatoString(localEvento);
    }

    public ZonedDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(ZonedDateTime dataHora) {
        validacaoDataHora(dataHora);
        this.dataHora = dataHora;
    }

    @Override
    public boolean estaNoFuturo() {
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
        try {
            validacaoDataHora(novaDataHora);
            setDataHora(novaDataHora);
            System.out.println("Evento reagendado com sucesso.");
        }catch (DataHoraInvalida35 e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome evento:"+getNomeEvento());
        System.out.println("Local evento:"+getLocalEvento());
        System.out.println("Data completa:"+getDataCompleta());
        System.out.println("Está no futuro?(sim | não):"+(estaNoFuturo() ? "Sim." : "Não."));
    }
}
