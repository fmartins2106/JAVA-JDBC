package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.HashSet;
import java.util.Set;

public abstract class Conta21 {
    protected Cliente21 cliente21;
    protected int numeroConta;
    protected double saldo;
    protected Cliente21.TipoConta21 tipoConta21;
    protected Cliente21.StatusConta21 statusConta21;

    public Conta21(Cliente21 cliente21, int numeroConta, double saldo, Cliente21.TipoConta21 tipoConta21, Cliente21.StatusConta21 statusConta21) {
        this.cliente21 = cliente21;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta21 = tipoConta21;
        this.statusConta21 = statusConta21;
    }

    public static final double DIGITOS_NUMERO_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private static Set<Integer> numeroContaCadastradas = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMERO_CONTA ){
            throw new IllegalArgumentException(Cliente21.MensagensValidacaoCliente21.ERRO_NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
        if (numeroContaCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(Cliente21.MensagensValidacaoCliente21.NUMERO_CONTA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente21.MensagensValidacaoCliente21.SALDO_MINIMO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta21 == Cliente21.StatusConta21.ATIVA){
            statusConta21 = Cliente21.StatusConta21.BLOQUEADA;
            System.out.println(Cliente21.MensagensValidacaoCliente21.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta21 == Cliente21.StatusConta21.BLOQUEADA){
            statusConta21 = Cliente21.StatusConta21.ATIVA;
            System.out.println(Cliente21.MensagensValidacaoCliente21.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_STATUS_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta21 == Cliente21.StatusConta21.ATIVA){
                statusConta21 = Cliente21.StatusConta21.CANCELADA;
                System.out.println(Cliente21.MensagensValidacaoCliente21.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_STATUS_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
        }
    }


    public void depositar(double valor){
        if (statusConta21 == Cliente21.StatusConta21.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(Cliente21.MensagensValidacaoCliente21.DEPOSITO.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_STATUS_CONTA_DEPOSITO.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente21 getCliente21() {
        return cliente21;
    }

    public void setCliente21(Cliente21 cliente21) {
        this.cliente21 = cliente21;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        numeroContaCadastradas.add(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente21.TipoConta21 getTipoConta21() {
        return tipoConta21;
    }

    public void setTipoConta21(Cliente21.TipoConta21 tipoConta21) {
        this.tipoConta21 = tipoConta21;
    }

    public Cliente21.StatusConta21 getStatusConta21() {
        return statusConta21;
    }

    public void setStatusConta21(Cliente21.StatusConta21 statusConta21) {
        this.statusConta21 = statusConta21;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo %.2f |Tipo conta: %s |Status conta: %s",
                cliente21.getNome(),cliente21.getCpf(),numeroConta,saldo,tipoConta21,statusConta21);
    }
}
