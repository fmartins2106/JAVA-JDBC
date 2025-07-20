package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida43;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase43;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase33;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class EventoBase43 implements Agendavel43 {
    private String nomeEvento;
    private String localEvento;
    private ZonedDateTime dataHora;

    public EventoBase43(String nomeEvento, String localEvento, ZonedDateTime dataHora) {
        setNomeEvento(nomeEvento);
        setLocalEvento(localEvento);
        setDataHora(dataHora);
    }
    //sdsdsd

    public static void validacaoNomeEvento(String nomerEvento){
        if (nomerEvento == null || nomerEvento.isEmpty() || !nomerEvento.matches("^[\\p{L}0-9,]+( [\\p{L}0-9,]+)*$")){
            throw new NomeEventoBase33();
        }
    }

    public static void validacaoLocalEvento(String localEvento){
        if (localEvento == null || localEvento.isEmpty() || !localEvento.matches("^[\\p{L}0-9,]+( [\\p{L}0-9,]+)*$")){
            throw new LocalEventoBase43();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoDataHoraEvento(ZonedDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraInvalida43();
        }
    }

    public String getNomerEvento() {
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
        validacaoDataHoraEvento(dataHora);
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
        try {
            validacaoDataHoraEvento(novaDataHora);
            setDataHora(novaDataHora);
            System.out.println("Evento reagendado com sucesso.");
        }catch (DataHoraInvalida43 e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome do evento:"+this.nomeEvento);
        System.out.println("Local do evento:"+this.localEvento);
        System.out.println("Data completa:"+getDataCompleta());
        System.out.println("Está no futuro ?:"+(estarNoFuturo() ? "Sim." : "Não."));
    }
}
