package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException06;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException06;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException06;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;

public class Fatura06 {
    private String numero;
    private double valor;
    private LocalDate dataVencimento;
    private LocalDateTime dataHoraCadastro;

    public Fatura06(String numero, double valor, LocalDate dataVencimento) {
        setNumero(numero);
        setValor(valor);
        setDataVencimento(dataVencimento);
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static void validacaoNumeroFatura(String numero){
        if (numero == null || numero.isEmpty() || !numero.matches("^[a-zA-Z0-9/._-]+$")){
            throw new NumeroFaturaException06();
        }
    }

    public static void validacaoValorFatura(double valor){
        if (valor < ValorFaturaException06.MENOR_VALOR_FATURA){
            throw new ValorFaturaException06();
        }
    }

    public static void validacaoDataVencimento(LocalDate dataVencimento){
        if (dataVencimento == null){
            throw new DataVencimentoFaturaException06();
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        validacaoNumeroFatura(numero);
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        validacaoValorFatura(valor);
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        validacaoDataVencimento(dataVencimento);
        this.dataVencimento = dataVencimento;
    }

    public Long getDiasAtraso(){
        return Math.max(0, ChronoUnit.DAYS.between(dataVencimento,LocalDate.now()));
    }

    public Period getAtrasoComPeriodo(){
        return Period.between(dataVencimento,LocalDate.now());
    }

    public LocalDate sugerirNovoVencimento(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public void exibirResumo(ResourceBundle bundle, double multa){
        Period p = getAtrasoComPeriodo();
        System.out.println("_________________________________________________________________________");
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.numero"),numero));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.valor"),valor));
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.vencimento"),dataVencimento));
        System.out.println(MessageFormat.format("{0} : {1} ano, {2} mese(s), {3} dia(s)", bundle.getString("fatura.atraso")
        , p.getYears(), p.getMonths(), p.getDays()));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}", bundle.getString("fatura.multa"),multa));
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.dataCadastro")
        ,dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        System.out.println("_________________________________________________________________________");
    }

}
