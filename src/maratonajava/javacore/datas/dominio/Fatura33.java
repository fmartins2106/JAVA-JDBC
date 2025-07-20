
package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException33;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException33;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException33;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;

public class Fatura33 {
    private String numero;
    private double valor;
    private LocalDate dataVencimento;
    private LocalDateTime dataHoraCadastro;

    public Fatura33(String numero, double valor, LocalDate dataVencimento) {
        setNumero(numero);
        setValor(valor);
        setDataVencimento(dataVencimento);
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static void validacaoNumero(String numero){
        if (numero == null || numero.isEmpty() || !numero.matches("^[a-zA-Z0-9/._-]+$")){
            throw new NumeroFaturaException33();
        }
    }

    public static void validacaoValorFatura(double valor){
        if (valor < ValorFaturaException33.MENOR_VALOR_FATURA){
            throw new ValorFaturaException33();
        }
    }

    public static void validacaoDataVencimento(LocalDate dataVencimento){
        if (dataVencimento == null /*|| dataVencimento.isBefore(LocalDate.now())*/){
            throw new DataVencimentoFaturaException33();
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
        validacaoValorFatura(valor);
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        validacaoDataVencimento(dataVencimento);
        this.dataVencimento = Feriados33.ajustarDataProximoDiaUtil(dataVencimento);
    }

    public Long getDiasAtraso(){
        return Math.max(0, ChronoUnit.DAYS.between(dataVencimento,LocalDate.now()));
    }

    public Period getPeriodoAtraso(){
        return Period.between(dataVencimento,LocalDate.now());
    }

    public LocalDate sugestaoDeVencimentoFatura(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public void exibirFatura(ResourceBundle bundle, double multa){
        System.out.println("_________________________________________________________________________________________");
        Period p = getPeriodoAtraso();
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.numero"),this.numero));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.valor"),this.valor));
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.vencimento"),this.dataVencimento));
        System.out.println(MessageFormat.format("{0} : {1} ano(s), {2} mes(es), {3} dia(s)",bundle.getString("fatura.atraso")
                ,p.getYears(),p.getMonths(),p.getDays()));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.multa"),multa));
        System.out.println(MessageFormat.format("{0} : {1}",bundle.getString("fatura.dataCadastro")
        ,dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        System.out.println("_________________________________________________________________________________________");
    }
}
