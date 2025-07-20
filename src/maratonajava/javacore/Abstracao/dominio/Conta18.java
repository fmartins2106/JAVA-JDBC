package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.HashSet;
import java.util.Set;

public abstract class Conta18 {
    protected Cliente18 cliente18;
    protected int numeroConta;
    protected double saldo;
    protected Cliente18.TipoConta18 tipoConta18;
    protected Cliente18.StatusConta18 statusConta18;

    public Conta18(Cliente18 cliente18, int numeroConta, double saldo, Cliente18.TipoConta18 tipoConta18, Cliente18.StatusConta18 statusConta18) {
        this.cliente18 = cliente18;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta18 = tipoConta18;
        this.statusConta18 = statusConta18;
    }

    public static final double SALDO_MINIMO = 0;
    public static final int DIGITOS_CONTA = 6;

    public static Set<Integer> contasBancarias = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(Cliente18.MensagensValidacaoCliente18.ERRO_DIGITOS_CONTA.getDescricaoFormatada(DIGITOS_CONTA));
        }
        if (contasBancarias.contains(numeroConta)){
            throw new IllegalArgumentException(Cliente18.MensagensValidacaoCliente18.ERRO_CONTA_REPETIDA.getDescricao());
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente18.MensagensValidacaoCliente18.ERRO_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta18 == Cliente18.StatusConta18.ATIVA){
            statusConta18 = Cliente18.StatusConta18.BLOQUEADA;
            System.out.println(Cliente18.MensagensValidacaoCliente18.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente18.MensagensValidacaoCliente18.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta18 == Cliente18.StatusConta18.BLOQUEADA){
            statusConta18 = Cliente18.StatusConta18.ATIVA;
            System.out.println(Cliente18.MensagensValidacaoCliente18.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente18.MensagensValidacaoCliente18.ERRO_DESBLOQUIO_CONTA.getDescricao());
        }
    }

    public void cancelamentoConta(){
        if (saldo == SALDO_MINIMO){
            statusConta18 = Cliente18.StatusConta18.CANCELADA;
            System.out.println(Cliente18.MensagensValidacaoCliente18.CONTA_CANCELADA.getDescricaoFormatada());
        }else {
            System.out.println(Cliente18.MensagensValidacaoCliente18.ERRO_CANCELAMENTO_CONTA.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void deposito(double valor){
        if (statusConta18 == Cliente18.StatusConta18.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(Cliente18.MensagensValidacaoCliente18.DEPOSITO_REALIZADO.getDescricaoFormatada(valor));
            }
        }
    }

    public abstract void sacar(double valor);

    public Cliente18 getCliente18() {
        return cliente18;
    }

    public void setCliente18(Cliente18 cliente18) {
        this.cliente18 = cliente18;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        contasBancarias.add(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente18.TipoConta18 getTipoConta18() {
        return tipoConta18;
    }

    public void setTipoConta18(Cliente18.TipoConta18 tipoConta18) {
        this.tipoConta18 = tipoConta18;
    }

    public Cliente18.StatusConta18 getStatusConta18() {
        return statusConta18;
    }

    public void setStatusConta18(Cliente18.StatusConta18 statusConta18) {
        this.statusConta18 = statusConta18;
    }

   @Override
   public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente18.getNome(),cliente18.getCpf(),numeroConta,saldo,tipoConta18,statusConta18);
   }

}
