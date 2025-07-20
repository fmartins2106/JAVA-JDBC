package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta31 {
    protected Cliente31 cliente31;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta31 tipoConta31;
    protected StatusConta31 statusConta31;

    public Conta31(Cliente31 cliente31, int numeroConta, double saldo, TipoConta31 tipoConta31, StatusConta31 statusConta31) {
        this.cliente31 = cliente31;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta31 = tipoConta31;
        this.statusConta31 = statusConta31;
    }

    private static final int DIGITOS_CONTA = 6;

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta31.NUMERO_CONTA.getDescricaoFormatada(DIGITOS_CONTA));
        }
    }

    private static Set<Integer> contaDuplicada = new HashSet<>();

    public static void validacaoContaDuplicada(int numeroConta){
        if (contaDuplicada.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta31.CONTA_DUPLICADA.getDescricao());
        }
    }

    private static final double SALDO_MINIMO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta31.SALDO_INVALIDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta31 == StatusConta31.ATIVA){
            statusConta31 = StatusConta31.BLOQUEADA;
            System.out.println(MensagensValidacaoConta31.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta31.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta31 == StatusConta31.BLOQUEADA){
            statusConta31 = StatusConta31.ATIVA;
            System.out.println(MensagensValidacaoConta31.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta31.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta31 == StatusConta31.ATIVA){
                statusConta31 = StatusConta31.CANCELADA;
                System.out.println(MensagensValidacaoConta31.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta31.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta31.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void depositar(double valor){
        if (statusConta31 == StatusConta31.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta31.DEPOSITO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta31.ERRO_DEPOSITO.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta31.ERRO_STATUS_DEPOSITO.getDescricao());
        }
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        contaDuplicada.add(numeroConta);
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public enum TipoConta31{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta31{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    public enum MensagensValidacaoConta31{
        NUMERO_CONTA("Número de conta precisa ter %d digitos para ter valídade."),
        CONTA_DUPLICADA("Conta duplicada."),
        DEPOSITO("Depósito no valor de R$%.2f realizado com sucesso."),
        ERRO_DEPOSITO("Operação negada. Valor inválido."),
        ERRO_STATUS_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        CONTA_BLOQUEADA("Conta cancelada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique o status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já esta cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Verifique saldo da conta. Conta precisa ter saldo igual a R$%.2f para efetuar o cancelamento."),
        SAQUE("Saque efetuado no valor de R$%.2f. | Taxa aplicada no valor de R$%.2f."),
        SAQUE_CP("Saque efetuado no valor de R$%.2f."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque deve ser menor que saldo de R$%.2f"),
        ERRO_STATUS_CONTA_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        SALDO_INVALIDO("Saldo não pode ser menor que %.2f.");

        private final String descricao;

        MensagensValidacaoConta31(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente31.getNome(), cliente31.getCpf(),numeroConta,saldo,tipoConta31,statusConta31);
    }
}
