package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta24 {
    protected Cliente24 cliente24;
    protected int numeroConta;
    protected double saldo;
    protected Cliente24.TipoConta24 tipoConta24;
    protected Cliente24.StatusConta24 statusConta24;

    public Conta24(Cliente24 cliente24, int numeroConta, double saldo, Cliente24.TipoConta24 tipoConta24, Cliente24.StatusConta24 statusConta24) {
        this.cliente24 = cliente24;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta24 = tipoConta24;
        this.statusConta24 = statusConta24;
    }

    public static final int PADRAO_DIGITOS_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != PADRAO_DIGITOS_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta24.DIGITOS_CONTA.getDescricaoFormada(PADRAO_DIGITOS_CONTA));
        }
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta24.CONTA_DUPLICADA.getDescricao());
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoConta24.ERRO_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta24 == Cliente24.StatusConta24.ATIVA){
            statusConta24 = Cliente24.StatusConta24.BLOQUEADA;
            System.out.println(MensagensValidacaoConta24.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta24.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta24 == Cliente24.StatusConta24.BLOQUEADA){
            statusConta24 = Cliente24.StatusConta24.ATIVA;
            System.out.println(MensagensValidacaoConta24.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(MensagensValidacaoConta24.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelamentoDeConta(){
        if (saldo == 0){
            if (statusConta24 == Cliente24.StatusConta24.ATIVA){
                statusConta24 = Cliente24.StatusConta24.CANCELADA;
                System.out.println(MensagensValidacaoConta24.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(MensagensValidacaoConta24.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta24.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void depositar(double valor){
        if (statusConta24 == Cliente24.StatusConta24.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println(MensagensValidacaoConta24.DEPOSITO_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta24.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(valor));
            }
        }else {
            System.out.println(MensagensValidacaoConta24.ERRO_STATUS_CONTA_DEPOSITO.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente24 getCliente24() {
        return cliente24;
    }

    public void setCliente24(Cliente24 cliente24) {
        this.cliente24 = cliente24;
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

    public Cliente24.TipoConta24 getTipoConta24() {
        return tipoConta24;
    }

    public void setTipoConta24(Cliente24.TipoConta24 tipoConta24) {
        this.tipoConta24 = tipoConta24;
    }

    public Cliente24.StatusConta24 getStatusConta24() {
        return statusConta24;
    }

    public void setStatusConta24(Cliente24.StatusConta24 statusConta24) {
        this.statusConta24 = statusConta24;
    }

    public enum MensagensValidacaoConta24{
        DIGITOS_CONTA("Conta precisa ter %d digitos para ter validade."),
        ERRO_SALDO("Saldo não pode ser menor %.2f"),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        CONTA_DUPLICADA("Conta duplicada. Verifique."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta. Sua conta pode já estar ativa ou cancelada."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta já pode estar cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Para efeutar o cancelamento seu saldo precisa ser igual a R$%.2f"),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        DEPOSITO_REALIZADO("Depósito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Operação negada. Para efetuar o depósito, valor precisa ser maior que R$%.2f."),
        ERRO_STATUS_CONTA_DEPOSITO("Operação negada. Verifique status da conta. Conta já pode estar bloqueada ou cancelada."),
        SAQUE_REALIZADO("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo em conta."),
        ERRO_STATUS_CONTA_SAQUE("Operação negada. Verifique status da conta. Conta já pode esta cancelada ou bloqueada."),
        SAQUE_CP_REALIZADO("Saque de R$%.2f realizado com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso.");

        private final String descricao;

        MensagensValidacaoConta24(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(String... valores){
            return String.format(descricao, (Object[]) valores);
        }

        public String getDescricaoFormada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente24.getNome(),cliente24.getCpf(),numeroConta,saldo,tipoConta24,statusConta24);
    }
}
