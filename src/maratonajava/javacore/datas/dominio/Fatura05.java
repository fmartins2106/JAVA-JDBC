package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException05;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException05;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException05;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;

public class Fatura05 {
    private String numero;
    private double valor;
    private LocalDate vencimento;
    private LocalDateTime dataHoraCadastro;

    public Fatura05(String numero, double valor, LocalDate vencimento) {
        setNumero(numero);
        setValor(valor);
        setVencimento(vencimento);
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static void validacaoNumero(String numero){
        if (numero == null || numero.isEmpty() || !numero.matches("^[A-Za-z0-9/._-]+$")){
            throw new NumeroFaturaException05();
        }
    }

    public static void validacaoValor(double valor){
        if (valor < ValorFaturaException05.MENOR_VALOR_FATURA){
            throw new ValorFaturaException05();
        }
    }

    public static void validacaoDataVencimento(LocalDate dataVencimento){
        if (dataVencimento == null){
            throw new DataVencimentoFaturaException05();
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        validacaoNumero(numero);
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        validacaoValor(valor);
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        validacaoDataVencimento(vencimento);
        this.vencimento = vencimento;
    }

    public long getDiasAtraso(){
        return Math.max(0, ChronoUnit.DAYS.between(vencimento,LocalDate.now()));
    }

    public Period getAtrasoComPeriodo(){
        return Period.between(vencimento,LocalDate.now());
    }

    public LocalDate sugerirNovoVencimento(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public void exibirResumo(ResourceBundle bundle,double multa){
        System.out.println("_________________________________________________________________________");
        Period p = getAtrasoComPeriodo();
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.numero")));
        System.out.println(MessageFormat.format("{0} :R${1,number,#,##0.00}", bundle.getString("fatura.valor"),valor));
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.vencimento"),vencimento));
        System.out.println(MessageFormat.format("{0} : {1} ano, {2} mês, {3} dia(s)",bundle.getString("fatura.atraso"),
                p.getYears(),p.getMonths(),p.getDays()));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}", bundle.getString("fatura.multa"),multa));
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.dataCadastro")
        ,dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        System.out.println("_________________________________________________________________________");
    }
}
