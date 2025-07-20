package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.HashSet;
import java.util.Set;

public abstract class Conta20 {
    protected Cliente20 cliente20;
    protected int numeroConta;
    protected double saldo;
    protected Cliente20.TipoConta20 tipoConta20;
    protected Cliente20.StatusConta20 statusConta20;

    public Conta20(Cliente20 cliente20, int numeroConta, double saldo, Cliente20.TipoConta20 tipoConta20, Cliente20.StatusConta20 statusConta20) {
        this.cliente20 = cliente20;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta20 = tipoConta20;
        this.statusConta20 = statusConta20;
    }

    public static final int DIGITOS_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    public static Set<Integer> listaContasCadastradas = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != 6){
            throw new IllegalArgumentException(Cliente20.MensagensValidacaoCliente20.DIGITOS_CONTA.getDescricaoFormatada(numeroConta));
        }
        if (listaContasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(Cliente20.MensagensValidacaoCliente20.CONTA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente20.MensagensValidacaoCliente20.ERRO_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta20 == Cliente20.StatusConta20.ATIVA){
            statusConta20 = Cliente20.StatusConta20.BLOQUEADA;
            System.out.println(Cliente20.MensagensValidacaoCliente20.BLOQUEIO_CONTA.getDescricao());
        }else {
            System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta20 == Cliente20.StatusConta20.ATIVA){
                statusConta20 = Cliente20.StatusConta20.CANCELADA;
                System.out.println(Cliente20.MensagensValidacaoCliente20.CANCELAMENTO_CONTA.getDescricao());
            }else {
                System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_CANCELAMENTO_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void desbloqueioConta(){
        if (statusConta20 == Cliente20.StatusConta20.BLOQUEADA){
            statusConta20 = Cliente20.StatusConta20.ATIVA;
            System.out.println(Cliente20.MensagensValidacaoCliente20.DESBLOQUEIO_CONTA.getDescricao());
        }else {
            System.out.println(Cliente20.MensagensValidacaoCliente20.DESBLOQUEIO_CONTA.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusConta20 == Cliente20.StatusConta20.ATIVA){
            if ( valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println(Cliente20.MensagensValidacaoCliente20.DEPOSITO_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_STATUS_CONTA_DEPOSITO.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente20 getCliente20() {
        return cliente20;
    }

    public void setCliente20(Cliente20 cliente20) {
        this.cliente20 = cliente20;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        listaContasCadastradas.add(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente20.TipoConta20 getTipoConta20() {
        return tipoConta20;
    }

    public void setTipoConta20(Cliente20.TipoConta20 tipoConta20) {
        this.tipoConta20 = tipoConta20;
    }

    public Cliente20.StatusConta20 getStatusConta20() {
        return statusConta20;
    }

    public void setStatusConta20(Cliente20.StatusConta20 statusConta20) {
        this.statusConta20 = statusConta20;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente20.getNome(), cliente20.getCpf(),numeroConta,saldo,tipoConta20,statusConta20);
    }

}
