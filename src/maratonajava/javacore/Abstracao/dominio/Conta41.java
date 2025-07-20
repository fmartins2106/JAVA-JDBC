package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada41;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida41;
import academy.devdojo.maratonajava.javacore.excessoes.SaldoInvalido41;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta41 {
    protected Cliente41 cliente41;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta41 tipoConta41;
    protected StatusConta41 statusConta41;

    public Conta41(Cliente41 cliente41, int numeroConta, double saldo, TipoConta41 tipoConta41, StatusConta41 statusConta41) {
        this.cliente41 = cliente41;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta41 = tipoConta41;
        this.statusConta41 = statusConta41;
    }

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != NumeroContaInvalida41.DIGITOS_NUMERO_CONTA){
            throw new NumeroContaInvalida41();
        }
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new NumeroContaDuplicada41();
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SaldoInvalido41.SALDO_MINIMO){
            throw new SaldoInvalido41();
        }
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta41 == StatusConta41.ATIVA){
            statusConta41 = StatusConta41.BLOQUEADA;
            System.out.println(MensagensValidacaoConta41.CONTA_BLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta41.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta41 == StatusConta41.BLOQUEADA){
            statusConta41 = StatusConta41.ATIVA;
            System.out.println(MensagensValidacaoConta41.CONTA_DESBLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta41.ERRO_CONTA_DESBLOQUEADA.getDescricao());
    }

    public void cancelarConta(){
        if (statusConta41 == StatusConta41.ATIVA){
            if (saldo == SaldoInvalido41.SALDO_MINIMO){
                statusConta41 = StatusConta41.CANCELADA;
                System.out.println(MensagensValidacaoConta41.CONTA_CANCELADA.getDescricao());
                return;
            }
            System.out.println(MensagensValidacaoConta41.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SaldoInvalido41.SALDO_MINIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta41.CONTA_CANCELADA.getDescricao());
    }

    public void depositar(double valor){
        if (statusConta41 == StatusConta41.ATIVA){
            if (valor > SaldoInvalido41.SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta41.DEPOSITO.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoConta41.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SaldoInvalido41.SALDO_MINIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta41.ERRO_DEPOSITO.getDescricao());
    }

    public void setCliente41(Cliente41 cliente41) {
        this.cliente41 = cliente41;
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

    public void setTipoConta41(TipoConta41 tipoConta41) {
        this.tipoConta41 = tipoConta41;
    }

    public void setStatusConta41(StatusConta41 statusConta41) {
        this.statusConta41 = statusConta41;
    }

    public enum TipoConta41{
        CORRENTE,POUPANÇA;
    }

    public enum StatusConta41{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    public enum MensagensValidacaoConta41{
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar bloqueada ou concelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Saldo da conta deve ser igual a R$%.2f para efetuar o cancelamento."),
        DEPOSITO("Depósito realizado no valor de R$%.2f."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor do depósito não pode ser menor que R$%.2f."),
        ERRO_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada.");

        private final String descricao;

        MensagensValidacaoConta41(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo:R$%.2f |Tipo conta: %s |Status conta: %s.",
                cliente41.getNome(),cliente41.getCpf(),numeroConta,saldo,tipoConta41,statusConta41);
    }
}
