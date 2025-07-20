
package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta28 {
    protected Cliente28 cliente28;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta28 tipoConta28;
    protected StatusConta28 statusConta28;

    public Conta28(Cliente28 cliente28, int numeroConta, double saldo, TipoConta28 tipoConta28, StatusConta28 statusConta28) {
        this.cliente28 = cliente28;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta28 = tipoConta28;
        this.statusConta28 = statusConta28;
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();
    public static final int DIGITOS_NUMERO_CONTA = 6;


    public static void validacaoDigitosNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta28.DIGITOS_NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
    }

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta28.NUMERO_CONTA_DUPLICADA.getDescricao());
        }
    }

    public static final double SALDO_MINIMO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta28.ERRO_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public Cliente28 getCliente28() {
        return cliente28;
    }

    public void setCliente28(Cliente28 cliente28) {
        this.cliente28 = cliente28;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoDigitosNumeroConta(numeroConta);
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

    public TipoConta28 getTipoConta28() {
        return tipoConta28;
    }

    public void setTipoConta28(TipoConta28 tipoConta28) {
        this.tipoConta28 = tipoConta28;
    }

    public StatusConta28 getStatusConta28() {
        return statusConta28;
    }

    public void setStatusConta28(StatusConta28 statusConta28) {
        this.statusConta28 = statusConta28;
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta28 == StatusConta28.ATIVA){
            statusConta28 = StatusConta28.BLOQUEADA;
            System.out.println(MensagensValidacaoConta28.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta28.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloqueada(){
        if (statusConta28 == StatusConta28.BLOQUEADA){
            statusConta28 = StatusConta28.ATIVA;
            System.out.println(MensagensValidacaoConta28.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta28.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (statusConta28 == StatusConta28.ATIVA){
            if (saldo == SALDO_MINIMO){
                throw new IllegalArgumentException(MensagensValidacaoConta28.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta28.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta28.ERRO_CONTA_CANCELADA.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusConta28 == StatusConta28.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta28.DEPOSITO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta28.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta28.ERRO_STATUS_CONTA_DEPOSITO.getDescricao());
        }
    }

    public enum TipoConta28{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta28{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    public enum MensagensValidacaoConta28{
        DIGITOS_NUMERO_CONTA("Número conta precisa ter %d digitos para ser validada."),
        NUMERO_CONTA_DUPLICADA("Conta duplicada."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_SALDO_CONTA_CANCELADA("Para efetuar cancelamento da conta seu saldo precisa ser igual a R$%.2f."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        DEPOSITO("Depósito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor do depósito deve ser maior que R$%.2f."),
        ERRO_STATUS_CONTA_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        SAQUE("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque precisa ser menor que saldo de R$%.2f."),
        ERRO_STATUS_CONTA_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        SAQUE_CONTACP("Saque de R$%.2f realizado com sucesso."),
        ERRO_SALDO("Saldo em conta não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoConta28(String descricao){
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
    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente28.getNome(),cliente28.getCpf(),numeroConta,saldo,tipoConta28,statusConta28);
    }
}

