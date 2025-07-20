package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException24;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException24;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException24;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;

public class Fatura24 {
    private String numeroFatura;
    private double valorFatura;
    private LocalDate vencimentoFatura;
    private LocalDateTime dataHoraCadastro;

    public Fatura24(String numeroFatura, double valorFatura, LocalDate vencimentoFatura) {
        setNumeroFatura(numeroFatura);
        setValorFatura(valorFatura);
        setVencimentoFatura(vencimentoFatura);
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static void validacaoNumeroFatura(String numeroFatura){
        if (numeroFatura == null || numeroFatura.isEmpty() || !numeroFatura.matches("^[a-zA-Z0-9/._-]+$"))
            throw new NumeroFaturaException24();
    }

    public static void validacaoValorFatura(double valorFatura){
        if (valorFatura < ValorFaturaException24.MENOR_VALOR_FATURA){
            throw new ValorFaturaException24();
        }
    }

    public static void valdiacaoVencimentoFatura(LocalDate vencimentoFatura){
        if (vencimentoFatura == null /*|| vencimentoFatura.isBefore(LocalDate.now())*/){
            throw new DataVencimentoFaturaException24();
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

    public LocalDate getVencimentoFatura() {
        return vencimentoFatura;
    }

    public void setVencimentoFatura(LocalDate vencimentoFatura) {
        valdiacaoVencimentoFatura(vencimentoFatura);
        this.vencimentoFatura = vencimentoFatura;
    }

    public Long getDiasAtraso(){
        return Math.max(0, ChronoUnit.DAYS.between(vencimentoFatura,LocalDate.now()));
    }

    public Period getPeriodoAtraso(){
        return Period.between(vencimentoFatura,LocalDate.now());
    }

    public LocalDate sugerirProximoVencimentoFatura(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public void exibirDadosFatura(ResourceBundle bundle, double multa){
        System.out.println("________________________________________________________________________________________");
        Period p = getPeriodoAtraso();
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.numero"),numeroFatura));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.valor"),valorFatura));
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.valor"),valorFatura));
        System.out.println(MessageFormat.format("{0} : {1} ano(s), {2} mes(es), {3} dia(s)",bundle.getString("fatura.atraso")
        ,p.getYears(),p.getMonths(),p.getDays()));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.multa"),multa));
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.dataCadastro")
        ,dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        System.out.println("________________________________________________________________________________________");
    }


}
