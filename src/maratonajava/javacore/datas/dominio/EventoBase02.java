package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida02;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase02;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase02;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class EventoBase02 implements Agendavel02{
    protected String nome;
    protected String local;
    protected ZonedDateTime dataHora;

    public EventoBase02(String nome, String local, ZonedDateTime dataHora) {
        setNome(nome);
        setLocal(local);
        setDataHora(dataHora);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeEventoBase02();
        }
    }

    public static void validacaoLocal(String local){
        if (local == null || local.isEmpty() || !local.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new LocalEventoBase02();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1)).collect(Collectors.joining(" "));
    }

    public static void validacaoDataLocal(ZonedDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraInvalida02();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoString(nome);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        validacaoLocal(local);
        this.local = formatoString(local);
    }

    public ZonedDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(ZonedDateTime dataHora) {
        validacaoDataLocal(dataHora);
        this.dataHora = dataHora;
    }

    @Override
    public boolean estarNoFuturo() {
        return dataHora.isAfter(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
    }

    @Override
    public void reagendar(int dias) {
        LocalDateTime novaData = this.dataHora.toLocalDateTime().plusDays(dias);
        ZonedDateTime novaDataHora = ZonedDateTime.of(novaData,this.dataHora.getZone());
        setDataHora(novaDataHora);
    }

    public String getDescricaoCompleta(){
        return dataHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(new Locale("pt","BR")));
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome:"+nome);
        System.out.println("Local:"+local);
        System.out.println("Data completa:"+getDescricaoCompleta());
        System.out.println("Está no futuro:"+ (estarNoFuturo() ? "Sim" : "Não"));
    }
}
