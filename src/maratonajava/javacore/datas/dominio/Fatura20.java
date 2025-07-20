package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException20;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException20;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException20;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;

public class Fatura20 {
    private String numero;
    private double valor;
    private LocalDate vencimento;
    private LocalDateTime dataHoraCadastro;

    public Fatura20(String numero, double valor, LocalDate vencimento) {
        setNumero(numero);
        setValor(valor);
        setVencimento(vencimento);
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static void validacaoNumeroFatura(String numero){
        if (numero == null || numero.isEmpty() || !numero.matches("^[a-zA-Z0-9/._-]+$")){
            throw new NumeroFaturaException20();
        }
    }

    public static void validacaoValorFatura(double valor){
        if (valor < ValorFaturaException20.MENOR_VALOR_FATURA){
            throw new ValorFaturaException20();
        }
    }

    public static void validacaoVencimentoFatura(LocalDate vencimento){
        if (vencimento == null /*|| vencimento.isBefore(LocalDate.now())*/){
            throw new DataVencimentoFaturaException20();
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

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        validacaoVencimentoFatura(vencimento);
        this.vencimento = Feriados20.ajustarProximoDiaUtil(vencimento);
    }

    public Long getDiasAtraso(){
        return Math.max(0, ChronoUnit.DAYS.between(vencimento,LocalDate.now()));
    }

    public Period getPeriodoComAtraso(){
        return Period.between(vencimento,LocalDate.now());
    }

    public static LocalDate sugestaoVencimentoProximaFatura(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public void exibirResumoFatura(ResourceBundle bundle, double multa){
        Period p = getPeriodoComAtraso();
        System.out.println("_______________________________________________________________________________________");
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.numero"),numero));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.valor"),valor));
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.vencimento"),vencimento));
        System.out.println(MessageFormat.format("{0} : {1} ano(s), {2} mes(es), {3} dias(s).",bundle.getString("fatura.atraso")
        ,p.getYears(),p.getMonths(),p.getDays()));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}", bundle.getString("fatura.multa"),multa));
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.dataCadastro"),
                dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        System.out.println("_______________________________________________________________________________________");
    }
}
