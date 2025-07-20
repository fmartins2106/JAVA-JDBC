package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException01;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException01;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException01;

import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ResourceBundle;

public class Fatura01 {
  private String numero;
  private double valor;
  private LocalDate vencimento;
  private Instant dataCadastro;
  private LocalDateTime dataHoraCadastro;

    public Fatura01(String numero, double valor, LocalDate vencimento) {
        setNumero(numero);
        setValor(valor);
        setVencimento(vencimento);
        this.dataCadastro = Instant.now();
        this.dataHoraCadastro = LocalDateTime.now();
    }

    public static void validacaoNumeroFatura(String numero){
        if (numero == null ||  numero.isEmpty() || !numero.matches("^[A-Za-z0-9/._-]+$")){
            throw new NumeroFaturaException01();
        }
    }

    public static void validacaoValorFatura(double valor){
        if (valor < ValorFaturaException01.MENOR_VALOR_FATURA){
            throw new ValorFaturaException01();
        }
    }

    public static void validacaoDataVencimento(LocalDate vencimento){
        if (vencimento == null ){
            throw new DataVencimentoFaturaException01();
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
        validacaoDataVencimento(vencimento);
        this.vencimento = vencimento;
    }

    public long getDiasAtraso(){
        return Math.max(0, ChronoUnit.DAYS.between(vencimento,LocalDate.now()));
    }

    public Period getAtrasoComoPeriodo(){
        return Period.between(vencimento,LocalDate.now());
    }

    public LocalDate sugerirNovoVencimento(){
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    public void exibirResumo(ResourceBundle bundle, double multa){
        Period p = getAtrasoComoPeriodo();
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.numero"),numero));
        System.out.println(MessageFormat.format("{0} : R${1,number, #,##0.00}", bundle.getString("fatura.valor"),valor));
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.vencimento"),vencimento));
        System.out.println(MessageFormat.format("{0} : {1} anos, {2} ,meses, {3} dias",
                bundle.getString("fatura.atraso"),p.getYears(),p.getMonths(),p.getDays()));
        System.out.println(MessageFormat.format("{0} : R${1,number,#,##0.00}",bundle.getString("fatura.multa"),multa));
        System.out.println(MessageFormat.format("{0} : {1}", bundle.getString("fatura.dataCadastro"),
                dataHoraCadastro.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));
        System.out.println("_____________________________________________________________________________________________");
    }



}
