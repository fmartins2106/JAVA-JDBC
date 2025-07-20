package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta30 {
    protected Cliente30 cliente30;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta30 tipoConta30;
    protected StatusConta30 statusConta30;

    public Conta30(Cliente30 cliente30, int numeroConta, double saldo, TipoConta30 tipoConta30, StatusConta30 statusConta30) {
        this.cliente30 = cliente30;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta30 = tipoConta30;
        this.statusConta30 = statusConta30;
    }

    public static Set<Integer> numeroContaCadastrada = new HashSet<>();
    private static final int DIGITOS_NUMERO_CONTA = 6;

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaSrt = String.valueOf(numeroConta);
        if (numeroContaSrt.length() != DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta30.NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
    }

    public static void validacaoContaDuplicada(int numeroConta){
        if (numeroContaCadastrada.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta30.NUMERO_CONTA_DUPLICADA.getDescricao());
        }
    }

    private static final double SALDO_MINIMO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta30.SALDO.getDescricaoFormadatada(SALDO_MINIMO));
        }
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta30 == StatusConta30.ATIVA){
            statusConta30 = StatusConta30.BLOQUEADA;
            System.out.println(MensagensValidacaoConta30.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta30.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta30 == StatusConta30.BLOQUEADA){
            statusConta30 = StatusConta30.ATIVA;
            System.out.println(MensagensValidacaoConta30.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta30.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta30 == StatusConta30.ATIVA){
                statusConta30 = StatusConta30.CANCELADA;
                System.out.println(MensagensValidacaoConta30.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta30.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta30.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormadatada(SALDO_MINIMO));
        }
    }

    public void depositar(double valor){
        if (statusConta30 == StatusConta30.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println(MensagensValidacaoConta30.DEPOSITO.getDescricaoFormadatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta30.ERRO_VALOR_DEPOSITO.getDescricaoFormadatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta30.ERRO_DEPOSITO_STATUS_CONTA.getDescricao());
        }
    }

    public Cliente30 getCliente30() {
        return cliente30;
    }

    public void setCliente30(Cliente30 cliente30) {
        this.cliente30 = cliente30;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        numeroContaCadastrada.add(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public TipoConta30 getTipoConta30() {
        return tipoConta30;
    }

    public void setTipoConta30(TipoConta30 tipoConta30) {
        this.tipoConta30 = tipoConta30;
    }

    public StatusConta30 getStatusConta30() {
        return statusConta30;
    }

    public void setStatusConta30(StatusConta30 statusConta30) {
        this.statusConta30 = statusConta30;
    }

    public enum MensagensValidacaoConta30{
        NUMERO_CONTA("Número de conta precisa ter %d digitos. Verifique !"),
        NUMERO_CONTA_DUPLICADA("Número de conta duplicada."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode estar já bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada, verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operaçaõ negada. Para efetuar cancelamento da conta saldo precisa ser igual a %R$.2f."),
        DEPOSITO("Depósito no valor de R$%.2f realizado com sucesso."),
        ERRO_DEPOSITO_STATUS_CONTA("Operação negada. Verifique status da conta. Conta pode estar já cancelada ou bloqueada."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor do depósito não pode ser menor que %.2f."),
        SAQUE("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        SAQUE_CP("Saque de R$.2f realizado com sucesso."),
        ERRO_VALOR_SAQUE("Operação negada, valor não pode ser maior que saldo de %.2f."),
        ERRO_SAQUE_STATUS_CONTA("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        SALDO("Saldo não pode ser menor que %.2f.");

        private final String descricao;

        MensagensValidacaoConta30(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormadatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta30{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta30{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    @Override
    public String toString(){
        return String.format("|Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente30.getNome(),cliente30.getCpf(),numeroConta,saldo,tipoConta30,statusConta30);
    }
}
