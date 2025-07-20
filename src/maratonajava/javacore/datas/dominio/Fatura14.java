package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException14;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException14;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException14;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;

public class Fatura14 {
    private String numero;
    private double valor;
    private LocalDate vencimento;
    private LocalDateTime dataHoraCadastro;

    public Fatura14(String numero, double valor, LocalDate vencimento) {
        setNumero(numero);
        setValor(valor);
        setVencimento(vencimento);
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static void validacaoNumeroFatura(String numero){
        if (numero == null || numero.isEmpty() || !numero.matches("^[a-zA-Z0-9/._-]+$")){
            throw new NumeroFaturaException14();
        }
    }

    public static void validacaoValorFatura(double valor){
        if (valor < ValorFaturaException14.MENOR_VALOR_FATURA){
            throw new ValorFaturaException14();
        }
    }

    public static void validacaoVencimento(LocalDate vencimento){
        if (vencimento == null /*|| vencimento.isBefore(LocalDate.now())*/){
            throw new DataVencimentoFaturaException14();
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
        validacaoVencimento(vencimento);
        this.vencimento = Feriados14.ajustarParaProximoDiaUtil(vencimento);
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

    public void exibirResumo(ResourceBundle bundle, double multa){
        System.out.println("_________________________________________________________________________________");
        Period p = getAtrasoComPeriodo();
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.numero"),numero));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}", bundle.getString("fatura.valor"),valor));
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.vencimento"),vencimento));
        System.out.println(MessageFormat.format("{0} : {1} ano(s), {2} mes(es), {3} dia(s)",bundle.getString("fatura.atraso")
        ,p.getYears(),p.getMonths(),p.getDays()));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.multa"),multa));
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.dataCadastro"),
                dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        System.out.println("_________________________________________________________________________________");
    }

}
