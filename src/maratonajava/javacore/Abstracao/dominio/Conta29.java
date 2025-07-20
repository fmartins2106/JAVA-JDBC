package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta29 {
    protected Cliente29 cliente29;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta29 tipoConta29;
    protected StatusConta29 statusConta29;

    public Conta29(Cliente29 cliente29, int numeroConta, double saldo, TipoConta29 tipoConta29, StatusConta29 statusConta29) {
        this.cliente29 = cliente29;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta29 = tipoConta29;
        this.statusConta29 = statusConta29;
    }

    private static final int DIGITOS_NUMERO_CONTA = 6;

    public static void validaacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length()  != DIGITOS_NUMERO_CONTA ){
            throw new IllegalArgumentException(MensagensValidacaoConta29.NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
    }

    public static Set<Integer> numeroDeContaCadastrada = new HashSet<>();

    public static void validandoNumeroDeContaDuplicada(int numeroConta){
        if (numeroDeContaCadastrada.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta29.NUMERO_CONTA_DUPLICADA.getDescricao());
        }
    }

    private static final double SALDO_MINIMO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta29.SALDO_MINIMO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta29 == StatusConta29.ATIVA){
            statusConta29 = StatusConta29.BLOQUEADA;
            System.out.println(MensagensValidacaoConta29.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta29.ERRO_STATUS_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta29 == StatusConta29.BLOQUEADA){
            statusConta29 = StatusConta29.ATIVA;
            System.out.println(MensagensValidacaoConta29.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta29.ERRO_STATUS_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta29 == StatusConta29.ATIVA){
                statusConta29 = StatusConta29.CANCELADA;
                System.out.println(MensagensValidacaoConta29.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta29.ERRO_STATUS_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta29.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void depositar(double valor){
        if (statusConta29 == StatusConta29.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta29.DEPOSITO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta29.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta29.STATUS_CONTA_DEPOSITO.getDescricao());
        }
    }

    public Cliente29 getCliente29() {
        return cliente29;
    }

    public void setCliente29(Cliente29 cliente29) {
        this.cliente29 = cliente29;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validaacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        numeroDeContaCadastrada.add(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public TipoConta29 getTipoConta29() {
        return tipoConta29;
    }

    public void setTipoConta29(TipoConta29 tipoConta29) {
        this.tipoConta29 = tipoConta29;
    }

    public StatusConta29 getStatusConta29() {
        return statusConta29;
    }

    public void setStatusConta29(StatusConta29 statusConta29) {
        this.statusConta29 = statusConta29;
    }

    public enum MensagensValidacaoConta29{
        NUMERO_CONTA("Conta precisa ter %d digitos para ser válida."),
        NUMERO_CONTA_DUPLICADA("Conta duplicada. Tente outro número."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_STATUS_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_STATUS_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_STATUS_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Para efetuar o cancelamento da conta, saldo da conta precisa ser igual a R$%.2f."),
        SAQUE_REALIZADO("Saque no valor de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo em conta -> R$%.2f"),
        ERRO_STATUS_CONTA_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        DEPOSITO("Depósito no valor de R$%.2f realizado com sucesso."),
        SAQUE_CP("Saque de R$%.2f realizado com sucesso."),
        STATUS_CONTA_DEPOSITO("Operação negada. Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        ERRO_VALOR_DEPOSITO("Operação negada. Para efetuar depósito, valor precisa ser maior que R$.%.2f."),
        SALDO_MINIMO("Saldo não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoConta29(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta29{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta29{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente29.getNome(),cliente29.getCpf(),numeroConta,saldo,tipoConta29,statusConta29);
    }
}
