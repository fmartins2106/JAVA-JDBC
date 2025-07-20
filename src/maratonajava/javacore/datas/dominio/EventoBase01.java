package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraEventoBase01;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase01;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase01;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class EventoBase01 implements Agendavel01 {
    protected String nome;
    protected String local;
    protected ZonedDateTime dataHora;

    public EventoBase01(String nome, String local, ZonedDateTime dataHora) {
        setNome(nome);
        setLocal(local);
        setDataHora(dataHora);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeEventoBase01();
        }
    }

    public static void validacaoLocal(String local){
        if (local == null || local.isEmpty() || !local.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new LocalEventoBase01();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validandoDataHora(ZonedDateTime dataHora){
        if (dataHora== null || dataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraEventoBase01();
        }
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoString(nome);
    }

    public void setLocal(String local) {
        validacaoLocal(local);
        this.local = formatoString(local);
    }

    public void setDataHora(ZonedDateTime dataHora) {
        validandoDataHora(dataHora);
        this.dataHora = dataHora;
    }

    public boolean estarNoFuturo(){
        return dataHora.isAfter(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
    }

    public String getDescricaoCompleta(){
        return dataHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(new Locale("pt","BR")));
    }

    public void reagendar(int dias){
        LocalDateTime novaData = this.dataHora.toLocalDateTime().plusDays(dias);
        ZonedDateTime novaDataHora = ZonedDateTime.of(novaData,this.dataHora.getZone());
        setDataHora(novaDataHora);
    }

    public void exibirInfo(){
        System.out.println("Nome:"+nome);
        System.out.println("Local:"+local);
        System.out.println("Data completa:"+getDescricaoCompleta());
        System.out.println("Está no futuro:"+ (estarNoFuturo() ? "Sim" : "não"));
    }

}
