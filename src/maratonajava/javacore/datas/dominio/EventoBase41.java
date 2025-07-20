
package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataHoraInvalida41;
import academy.devdojo.maratonajava.javacore.datas.execessoes.LocalEventoBase41;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase41;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class EventoBase41 implements Agendavel41{
    private String nome;
    private String local;
    private ZonedDateTime dataHora;

    public EventoBase41(String nome, String local, ZonedDateTime dataHora) {
        setNome(nome);
        setLocal(local);
        setDataHora(dataHora);
    }

    public static void validacaoNomeEvento(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9,]+( [\\p{L}0-9,]+)*$")){
            throw new NomeEventoBase41();
        }
    }

    public static void validacaoLocalEvento(String local){
        if (local == null || local.isEmpty() || !local.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new LocalEventoBase41();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoDataHora(ZonedDateTime dataHora){
        if (dataHora == null || dataHora.isBefore(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new DataHoraInvalida41();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNomeEvento(nome);
        this.nome = formatoString(nome);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        validacaoLocalEvento(local);
        this.local = formatoString(local);
    }

    public ZonedDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(ZonedDateTime dataHora) {
        validacaoDataHora(dataHora);
        this.dataHora = dataHora;
    }

    @Override
    public boolean estarNoFuturo() {
        return dataHora.isAfter(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
    }

    @Override
    public void reagendar(int dias) {
        LocalDateTime dataHora = this.dataHora.toLocalDateTime().plusDays(dias);
        ZonedDateTime novaDataHora = ZonedDateTime.of(dataHora,this.dataHora.getZone());
        try {
            validacaoDataHora(novaDataHora);
            setDataHora(novaDataHora);
        }catch (DateTimeException e){
            System.out.println(e.getMessage());
        }
    }

    public String getDataCompleta(){
        return dataHora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(new Locale("pt","BR")));
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome evento:"+this.nome);
        System.out.println("Local do evento:"+this.local);
        System.out.println("Data completa:"+getDataCompleta());
        System.out.println("Está no futuro?"+(estarNoFuturo() ? "Sim." : "Não."));
    }
}
