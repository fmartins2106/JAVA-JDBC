package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta32 {
    protected Cliente32 cliente32;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta32 tipoConta32;
    protected StatusConta32 statusConta32;

    public Conta32(Cliente32 cliente32, int numeroConta, double saldo, TipoConta32 tipoConta32, StatusConta32 statusConta32) {
        this.cliente32 = cliente32;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta32 = tipoConta32;
        this.statusConta32 = statusConta32;
    }

    private static final int DIGITOS_CONTA = 6;

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta32.NUMERO_CONTA.getDescricaoFormatada(DIGITOS_CONTA));
        }
    }

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta32.CONTA_DUPLICADA.getDescricao());
        }
    }

    private static final double SALDO_MINIMO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta32.SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta32 == StatusConta32.ATIVA){
            statusConta32 = StatusConta32.BLOQUEADA;
            System.out.println(MensagensValidacaoConta32.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta32.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta32 == StatusConta32.BLOQUEADA){
            statusConta32 = StatusConta32.ATIVA;
            System.out.println(MensagensValidacaoConta32.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta32.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (statusConta32 == StatusConta32.ATIVA){
            if (saldo == SALDO_MINIMO){
                statusConta32 = StatusConta32.CANCELADA;
                System.out.println(MensagensValidacaoConta32.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta32.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta32.ERRO_CONTA_CANCELADA.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public void depositar(double valor){
        if (statusConta32 == StatusConta32.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta32.DEPOSITO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta32.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta32.ERRO_STATUS_CONTA_DEPOSITO.getDescricaoFormatada());
        }
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

    public enum TipoConta32{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta32{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    public enum MensagensValidacaoConta32{
        NUMERO_CONTA("Número conta precisa ter %d digitos para ser validada."),
        CONTA_DUPLICADA("Conta duplicada."),
        SALDO("Saldo não pode ser menor que %.2f."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada, verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada, verifique status da conta."),
        DEPOSITO("Depósito realizado com sucesso no valor de R$%.2f."),
        ERRO_VALOR_DEPOSITO("Operação negada, valor do deposito precisa ser maior que %.2f."),
        ERRO_STATUS_CONTA_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        SAQUE("Saque realizado no valor de R$%.2f. Taxa de R$%.2f aplicada."),
        SAQUE_CP("Saque realizado no valor de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo de R$%.2f"),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Verifique saldo da conta. Saldo precisa ser igual a R$%.2f.");

        private final String descricao;

        MensagensValidacaoConta32(String descricao) {
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
                cliente32.getNome(),cliente32.getCpf(),numeroConta,saldo,tipoConta32,statusConta32);
    }
}
