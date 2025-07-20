package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta34 {
    protected Cliente34 cliente34;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta34 tipoConta34;
    protected StatusConta34 statusConta34;

    public Conta34(Cliente34 cliente34, int numeroConta, double saldo, TipoConta34 tipoConta34, StatusConta34 statusConta34) {
        this.cliente34 = cliente34;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta34 = tipoConta34;
        this.statusConta34 = statusConta34;
    }

    private static final int DIGITOS_NUMERO_CONTA = 6;

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta34.NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoNumeroContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta34.NUMERO_CONTA_DUPLICADA.getDescricao());
        }
    }

    private static final double SALDO_MINIMO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta34.SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void setCliente34(Cliente34 cliente34) {
        this.cliente34 = cliente34;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        contasCadastradas.add(numeroConta);
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public void setTipoConta34(TipoConta34 tipoConta34) {
        this.tipoConta34 = tipoConta34;
    }

    public void setStatusConta34(StatusConta34 statusConta34) {
        this.statusConta34 = statusConta34;
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta34 == StatusConta34.ATIVA){
            statusConta34 = StatusConta34.BLOQUEADA;
            System.out.println(MensagensValidacaoConta34.BLOQUEAR_CONTA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta34.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta34 == StatusConta34.BLOQUEADA){
            statusConta34 = StatusConta34.ATIVA;
            System.out.println(MensagensValidacaoConta34.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta34.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (statusConta34 == StatusConta34.ATIVA){
            if (saldo == SALDO_MINIMO){
                statusConta34 = StatusConta34.CANCELADA;
                System.out.println(MensagensValidacaoConta34.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta34.ERRO_VALOR_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta34.ERRO_CONTA_CANCELADA.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusConta34 == StatusConta34.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta34.DEPOSITO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta34.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta34.ERRO_DEPOSITO.getDescricao());
        }
    }

    public enum MensagensValidacaoConta34{
        NUMERO_CONTA("Número da conta não pode ser menor que %d."),
        NUMERO_CONTA_DUPLICADA("Número de conta duplicada. Verifique."),
        SALDO("Saldo não pode ser menor que R$%.2f."),
        BLOQUEAR_CONTA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada, verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada, Verifique status da conta."),
        DEPOSITO("Depósito realizado com sucesso no valor de R$%.2f."),
        ERRO_DEPOSITO("Operação negada, Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        ERRO_VALOR_DEPOSITO("Operação negada. Verifique o valor do depósito. Não pode ser menor que R$%.2f."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        ERRO_VALOR_CONTA_CANCELADA("Operação negada, verifique status da conta. Saldo precisa ser igual a R$%.2f.");

        private final String descricao;

        MensagensValidacaoConta34(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        private String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta34{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta34{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente34.getNome(),cliente34.getCpf(),numeroConta,saldo,tipoConta34,statusConta34);
    }
}
