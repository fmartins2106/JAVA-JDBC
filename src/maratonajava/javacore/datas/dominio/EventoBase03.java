package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida03;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase03;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase03;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class EventoBase03 implements Agendavel03{
    protected String nome;
    protected String local;
    protected ZonedDateTime dataHora;

    public EventoBase03(String nome, String local, ZonedDateTime dataHora) {
        setNome(nome);
        setLocal(local);
        setDataHora(dataHora);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeEventoBase03();
        }
    }

    public static void validacaoLocal(String local){
        if (local == null || local.isEmpty() || !local.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new LocalEventoBase03();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoDataHora(ZonedDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraInvalida03();
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
        validacaoDataHora(dataHora);
        this.dataHora = dataHora;
    }

    @Override
    public boolean estaNoFuturo() {
        return dataHora.isAfter(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
    }

    public String getDescricaoCompleta(){
        return dataHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(new Locale("pt","BR")));
    }

    @Override
    public void reagendar(int dias) {
        LocalDateTime dataHora = this.dataHora.toLocalDateTime().plusDays(dias);
        ZonedDateTime novaDataHora = ZonedDateTime.of(dataHora,this.dataHora.getZone());
        setDataHora(novaDataHora);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome:"+nome);
        System.out.println("Local:"+local);
        System.out.println("Data completa:"+getDescricaoCompleta());
        System.out.println("Esta no futuro:"+(estaNoFuturo() ? "Sim" : "Não"))                                                  ;
    }
}
