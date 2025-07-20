package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta25 {
    protected Cliente25 cliente25;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta25 tipoConta25;
    protected StatusConta25 statusConta25;

    public Conta25(Cliente25 cliente25, int numeroConta, double saldo, TipoConta25 tipoConta25, StatusConta25 statusConta25) {
        this.cliente25 = cliente25;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta25 = tipoConta25;
        this.statusConta25 = statusConta25;
    }

    public static final int DIGITOS_NUMERO_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMERO_CONTA ){
            throw new IllegalArgumentException(MensagensValidacaoConta25.DIGITOS_NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta25.CONTA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta25.SALDO_MINIMO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta25 == StatusConta25.ATIVA){
            statusConta25 = StatusConta25.BLOQUEADA;
            System.out.println(MensagensValidacaoConta25.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta25.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta25 == StatusConta25.BLOQUEADA){
            statusConta25 = StatusConta25.ATIVA;
            System.out.println(MensagensValidacaoConta25.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta25.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta25 == StatusConta25.ATIVA){
                statusConta25 = StatusConta25.CANCELADA;
                System.out.println(MensagensValidacaoConta25.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta25.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta25.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void depositar(double valor){
        if (statusConta25 == StatusConta25.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println(MensagensValidacaoConta25.DEPOSITO_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta25.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta25.ERRO_STATUS_CONTA_DEPOSITO.getDescricao());
        }
    }

    public abstract void sacar(double valor);


    public Cliente25 getCliente25() {
        return cliente25;
    }

    public void setCliente25(Cliente25 cliente25) {
        this.cliente25 = cliente25;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        contasCadastradas.add(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public TipoConta25 getTipoConta25() {
        return tipoConta25;
    }

    public void setTipoConta25(TipoConta25 tipoConta25) {
        this.tipoConta25 = tipoConta25;
    }

    public StatusConta25 getStatusConta25() {
        return statusConta25;
    }

    public void setStatusConta25(StatusConta25 statusConta25) {
        this.statusConta25 = statusConta25;
    }

    public enum TipoConta25{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta25{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    public enum MensagensValidacaoConta25{
        DIGITOS_NUMERO_CONTA("Para conta ter validade. Número de conta precisa ter %d digitos."),
        CONTA_DUPLICADA("Conta duplicada."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode esta cancelada ou bloqueada."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Para efetuar cancelamento da conta. Seu saldo precisa ser igual a R$%.2f"),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta. Conta pode estar já ativa ou cancelada."),
        DEPOSITO_REALIZADO("Depósito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor do depósito precisa ser maior que %.2f."),
        ERRO_STATUS_CONTA_DEPOSITO("Operação negada. Status da conta precisa estar ativa para efetuar o depósito. Verifique."),
        SAQUE_REALIADO("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f realizado."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque deve ser menor que %.2f"),
        ERRO_STATUS_CONTA_SAQUE("Operação negada. Para efetuar o saque, conta precisa estar ativa. Verifique !"),
        SAQUE_REALIZADO_CP("Saque de R$%.2f realizado com sucesso."),
        SALDO_MINIMO("Saldo não pode ser menor que %.2f");

        private final String descricao;

        MensagensValidacaoConta25(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente25.getNome(),cliente25.getCpf(),numeroConta,saldo,tipoConta25,statusConta25);
    }
}
