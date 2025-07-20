package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException25;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException25;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException25;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;

public class Fatura25 {
    private String numeroFatura;
    private double valorFatura;
    private LocalDate vencimento;
    private LocalDateTime dataHoraCadastro;

    public Fatura25(String numeroFatura, double valorFatura, LocalDate vencimento) {
        setNumeroFatura(numeroFatura);
        setValorFatura(valorFatura);
        setVencimento(vencimento);
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static void validacaoNumeroFatura(String numeroFatura){
        if (numeroFatura == null || numeroFatura.isEmpty() || !numeroFatura.matches("^[A-Za-z0-9/._-]+$")){
            throw new NumeroFaturaException25();
        }
    }

    public static void validacaoValorFatura(double valorFatura){
        if (valorFatura < ValorFaturaException25.MENOR_VALOR_FATURA){
            throw new ValorFaturaException25();
        }
    }

    public static void validacaoDataVencimento(LocalDate vencimento){
        if (vencimento == null /*|| vencimento.isBefore(LocalDate.now())*/){
            throw new DataVencimentoFaturaException25();
        }
    }

    public String getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(String numeroFatura) {
        validacaoNumeroFatura(numeroFatura);
        this.numeroFatura = numeroFatura;
    }

    public double getValorFatura() {
        return valorFatura;
    }

    public void setValorFatura(double valorFatura) {
        validacaoValorFatura(valorFatura);
        this.valorFatura = valorFatura;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        validacaoDataVencimento(vencimento);
        this.vencimento = vencimento;
    }

    public Long getDiasAtraso(){
        return Math.max(0, ChronoUnit.DAYS.between(vencimento,LocalDate.now()));
    }

    public Period getPeriodoAtraso(){
        return Period.between(vencimento,LocalDate.now());
    }

    public LocalDate sugestaoProximoVencimento(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public void exibirDadosFatura(ResourceBundle bundle, double multa){
        Period p = getPeriodoAtraso();
        System.out.println("_______________________________________________________________________________________");
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.numero"),numeroFatura));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.valor"),valorFatura));
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.vencimento"),vencimento));
        System.out.println(MessageFormat.format("{0} : {1} ano(s), {2} mes(es), {3} dia(s)",bundle.getString("fatura.atraso")
        ,p.getYears(),p.getMonths(),p.getDays()));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.multa"),multa));
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.dataCadastro"),
                dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        System.out.println("_______________________________________________________________________________________");
    }
}
