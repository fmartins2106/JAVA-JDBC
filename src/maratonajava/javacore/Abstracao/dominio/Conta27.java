package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta27 {
    protected Cliente27 cliente27;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta27 tipoConta27;
    protected StatusConta27 statusConta27;

    public Conta27(Cliente27 cliente27, int numeroConta, double saldo, TipoConta27 tipoConta27, StatusConta27 statusConta27) {
        this.cliente27 = cliente27;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta27 = tipoConta27;
        this.statusConta27 = statusConta27;
    }

    public static final int DIGITOS_NUMERO_CONTA = 6;

    private static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta27.DIGITOS_NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta27.NUMERO_CONTA_DUPLICADA.getDescricao());
        }
    }

    public static final double SALDO_MINIMO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta27.ERRO_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public Cliente27 getCliente27() {
        return cliente27;
    }

    public void setCliente27(Cliente27 cliente27) {
        this.cliente27 = cliente27;
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

    public TipoConta27 getTipoConta27() {
        return tipoConta27;
    }

    public void setTipoConta27(TipoConta27 tipoConta27) {
        this.tipoConta27 = tipoConta27;
    }

    public StatusConta27 getStatusConta27() {
        return statusConta27;
    }

    public void setStatusConta27(StatusConta27 statusConta27) {
        this.statusConta27 = statusConta27;
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta27 == StatusConta27.ATIVA){
            statusConta27 = StatusConta27.BLOQUEADA;
            System.out.println(MensagensValidacaoConta27.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta27.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta27 == StatusConta27.BLOQUEADA){
            statusConta27 = StatusConta27.ATIVA;
            System.out.println(MensagensValidacaoConta27.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta27.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void contaCancelada(){
        if (saldo == SALDO_MINIMO){
            if (statusConta27 == StatusConta27.ATIVA){
                statusConta27 = StatusConta27.CANCELADA;
                System.out.println(MensagensValidacaoConta27.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta27.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta27.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
        }

    }

    public void depositar(double valor){
        if (statusConta27 == StatusConta27.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println(MensagensValidacaoConta27.DEPOSITO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta27.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(MensagensValidacaoConta27.CONTA_CANCELADA.getDescricao());
        }
    }

    public enum MensagensValidacaoConta27{
        DIGITOS_NUMERO_CONTA("Conta precisa ter %d digitos."),
        NUMERO_CONTA_DUPLICADA("Conta duplicada."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso!"),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        DEPOSITO("Depósito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Valor do depósito não pode ser menor que R$%.2f."),
        ERRO_STATUS_CONTA_DEPOSITO("Operação negada. Verifique status da conta."),
        ERRO_SALDO_CONTA_CANCELADA("Para efetuar o canelamento da conta. O saldo precisa ser igual que R$%.2f."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        SAQUE("Depósito de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque deve ser menor que saldo de R$%.2f"),
        ERRO_STATUS_CONTA_SAQUE("Operação negada. Verifique status da conta."),
        SAQUE_CP("Saque de R$%.2f realizado com sucesso."),
        ERRO_SALDO("Saldo não pode ser menor que %.2f.");

        private final String descricao;

        MensagensValidacaoConta27(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }


        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

    }

    public enum TipoConta27{
        CORRENTE,POUPANÇA;
    }

    public enum StatusConta27{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente27.getNome(),cliente27.getCpf(),numeroConta,saldo,tipoConta27,statusConta27);
    }
}
