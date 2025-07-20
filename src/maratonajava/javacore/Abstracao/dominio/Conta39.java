package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada39;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida39;
import academy.devdojo.maratonajava.javacore.excessoes.SaldoInvalido39;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public abstract class Conta39 {
    protected Cliente39 cliente39;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta39 tipoConta39;
    protected StatusConta39 statusConta39;

    public Conta39(Cliente39 cliente39, int numeroConta, double saldo, TipoConta39 tipoConta39, StatusConta39 statusConta39) {
        this.cliente39 = cliente39;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta39 = tipoConta39;
        this.statusConta39 = statusConta39;
    }

    public static void validacaoNumeroConta(int numeroConta){
        if (numeroConta < NumeroContaInvalida39.DIGITOS_NUMERO_CONTA){
            throw new NumeroContaInvalida39();
        }
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new NumeroContaDuplicada39();
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SaldoInvalido39.SALDO_MINIMO){
            throw new SaldoInvalido39();
        }
    }

    public void setCliente39(Cliente39 cliente39) {
        this.cliente39 = cliente39;
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

    public void setTipoConta39(TipoConta39 tipoConta39) {
        this.tipoConta39 = tipoConta39;
    }

    public void setStatusConta39(StatusConta39 statusConta39) {
        this.statusConta39 = statusConta39;
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta39 == StatusConta39.ATIVA){
            statusConta39 = StatusConta39.BLOQUEADA;
            System.out.println(MensagensValidacaoConta39.CONTA_BLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta39.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void contaDesbloqueada(){
        if (statusConta39 == StatusConta39.BLOQUEADA){
            statusConta39 = StatusConta39.ATIVA;
            System.out.println(MensagensValidacaoConta39.CONTA_DESBLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta39.ERRO_CONTA_DESBLOQUEADA.getDescricao());
    }

    public void contaCancelada(){
        if (statusConta39 == StatusConta39.ATIVA){
            if (saldo == SaldoInvalido39.SALDO_MINIMO){
                statusConta39 = StatusConta39.CANCELADA;
                System.out.println(MensagensValidacaoConta39.CONTA_CANCELADA.getDescricao());
                return;
            }
            System.out.println(MensagensValidacaoConta39.ERRO_VALOR_CONTA_CANCELADA.getDescricaoFormatada(SaldoInvalido39.SALDO_MINIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta39.CONTA_CANCELADA.getDescricao());
    }

    public void depositar(double valor){
        if (statusConta39 == StatusConta39.ATIVA){
            if (valor > SaldoInvalido39.SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta39.DEPOSITO.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoConta39.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SaldoInvalido39.SALDO_MINIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta39.ERRO_DEPOSITO.getDescricao());
    }

    public enum TipoConta39{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta39{
        ATIVA,BLOQUEADA,CANCELADA;
    }

    public enum MensagensValidacaoConta39{
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode estar já bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        ERRO_VALOR_CONTA_CANCELADA("Operação negada. Para efetuar o cancelamento da conta, saldo precisa ser igual a R$%.2f."),
        DEPOSITO("Depósito realizado no valor de R$%.2f."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor do depósito não pode ser menor que R$%.2f."),
        ERRO_DEPOSITO("Operação negada. Verifique status da conta.");

        private final String descricao;

        MensagensValidacaoConta39(String descricao) {
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
    public String toString() {
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente39.getNome(),cliente39.getCpf(),numeroConta,saldo,tipoConta39,statusConta39);
    }
}
