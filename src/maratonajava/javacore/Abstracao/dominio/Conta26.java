package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta26 {
    protected Cliente26 cliente26;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta26 tipoConta26;
    protected StatusConta26 statusConta26;

    public Conta26(Cliente26 cliente26, int numeroConta, double saldo, TipoConta26 tipoConta26, StatusConta26 statusConta26) {
        this.cliente26 = cliente26;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta26 = tipoConta26;
        this.statusConta26 = statusConta26;
    }

    public abstract void sacar(double valor);

    public void depositar(double valor){
        if (statusConta26 == StatusConta26.ATIVA){
            if (valor > MENOR_SALDO){
                saldo+=valor;
                System.out.println(MensagensValidacaoConta26.DEPOSITO_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta26.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(MENOR_SALDO));
            }
        }else {
            System.out.println(MensagensValidacaoConta26.ERRO_STATUS_CONTA_DEPOSITO.getDescricao());
        }
    }

    public void bloquearConta(){
        if (statusConta26 == StatusConta26.ATIVA){
            statusConta26 = StatusConta26.BLOQUEADA;
            System.out.println(MensagensValidacaoConta26.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta26.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta26 == StatusConta26.BLOQUEADA){
            statusConta26 = StatusConta26.ATIVA;
            System.out.println(MensagensValidacaoConta26.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta26.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == MENOR_SALDO){
            if (statusConta26 == StatusConta26.ATIVA){
                statusConta26 = StatusConta26.CANCELADA;
                System.out.println(MensagensValidacaoConta26.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta26.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else{
            System.out.println(MensagensValidacaoConta26.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(MENOR_SALDO));
        }
    }

    public static final int DIGITOS_NUMERO_CONTA = 6;
    public static final double MENOR_SALDO = 0;

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta26.DIGITOS_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta26.CONTA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < MENOR_SALDO){
            throw new IllegalArgumentException(MensagensValidacaoConta26.SALDO.getDescricaoFormatada(MENOR_SALDO));
        }
    }

    public Cliente26 getCliente26() {
        return cliente26;
    }

    public void setCliente26(Cliente26 cliente26) {
        this.cliente26 = cliente26;
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

    public TipoConta26 getTipoConta26() {
        return tipoConta26;
    }

    public void setTipoConta26(TipoConta26 tipoConta26) {
        this.tipoConta26 = tipoConta26;
    }

    public StatusConta26 getStatusConta26() {
        return statusConta26;
    }

    public void setStatusConta26(StatusConta26 statusConta26) {
        this.statusConta26 = statusConta26;
    }

    public enum MensagensValidacaoConta26{
        DIGITOS_CONTA("Número de conta inválido. Conta precisa ter %d digitos."),
        CONTA_DUPLICADA("Número de conta duplicada."),
        DEPOSITO_REALIZADO("Depósito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor do depósito não pode ser menor que R$%.2f."),
        ERRO_STATUS_CONTA_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar já cancelada ou bloqueada."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Para efetuar cancelamento da conta seu saldo precia ser igual a R$%.2f"),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        SAQUE_REALIZADO("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque deve ser menor que saldo em conta de R$%.2f."),
        ERRO_STATUS_CONTA_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        SAQUE_CP("Saque de R$%.2f realizado com sucesso."),
        SALDO("Saldo não pode ser menor que %.2f.");

        private final String descricao;

        MensagensValidacaoConta26(String descricao){
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

    public enum TipoConta26{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta26{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente26.getNome(),cliente26.getCpf(),numeroConta,saldo,tipoConta26,statusConta26);
    }
}
