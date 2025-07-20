package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta33 {
    protected Cliente33 cliente33;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta33 tipoConta33;
    protected StatusConta33 statusConta33;

    public Conta33(Cliente33 cliente33, int numeroConta, double saldo, TipoConta33 tipoConta33, StatusConta33 statusConta33) {
        this.cliente33 = cliente33;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta33 = tipoConta33;
        this.statusConta33 = statusConta33;
    }

    private static final int DIGITOS_NUMERO_CONTA = 6;

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta33.NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta33.NUMERO_CONTA_DUPLICADA.getDescricao());
        }
    }

    private static final double SALDO_MINIMO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta33.SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
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

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta33 == StatusConta33.ATIVA){
            statusConta33 = StatusConta33.BLOQUEADA;
            System.out.println(MensagensValidacaoConta33.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta33.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta33 == StatusConta33.BLOQUEADA){
            statusConta33 = StatusConta33.ATIVA;
            System.out.println(MensagensValidacaoConta33.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta33.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (statusConta33 == StatusConta33.ATIVA){
            if (saldo == SALDO_MINIMO){
                statusConta33 = StatusConta33.CANCELADA;
                System.out.println(MensagensValidacaoConta33.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta33.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta33.ERRO_CONTA_CANCELADA.getDescricao());
        }
    }

    public void depositarValor(double valor){
        if (statusConta33 == StatusConta33.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta33.DEPOSITO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta33.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta33.ERRO_DEPOSITO.getDescricao());
        }
    }

    public enum MensagensValidacaoConta33{
        NUMERO_CONTA("Número conta precia ter %d digitos para ter validada."),
        NUMERO_CONTA_DUPLICADA("Conta duplicada."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Verifique saldo da conta. Conta de ter saldo iqual a R$%.2f para efetuar o cancelamento."),
        DEPOSITO("Depósito no valor de R$%.2f realizado com sucesso."),
        ERRO_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_DEPOSITO("Valor do depósito inválido. Valor precisa ser maior que R$%.2f."),
        SAQUE_REALIZADO("Saque no valor de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        SAQUE_REALIZADO_CP("Saque realizado no valor de R$%.2f."),
        ERRO_SAQUE_VALOR("Operação negada. Valor do saque precisa ser menor que saldo de R$%.2f."),
        ERRO_SAQUE_STATUS_CONTA("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        SALDO("Saldo não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoConta33(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }

    }

    public enum TipoConta33{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta33{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente33.getNome(),cliente33.getCpf(),numeroConta,saldo,tipoConta33,statusConta33);
    }
}

