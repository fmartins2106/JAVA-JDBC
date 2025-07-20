package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta36 {
    protected Cliente36 cliente36;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta36 tipoConta36;
    protected StatusConta36 statusConta36;

    public Conta36(Cliente36 cliente36, int numeroConta, double saldo, TipoConta36 tipoConta36, StatusConta36 statusConta36) {
        this.cliente36 = cliente36;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta36 = tipoConta36;
        this.statusConta36 = statusConta36;
    }

    private static final int DIGITOS_CONTA = 6;

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta36.DIGITOS_CONTA.getDescricaoFormatada(DIGITOS_CONTA));
        }
    }

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta36.CONTA_DUPLICADA.getDescricao());
        }
    }

    private static final double MENOR_SALDO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < MENOR_SALDO){
            throw new IllegalArgumentException(MensagensValidacaoConta36.SALDO.getDescricaoFormatada(MENOR_SALDO));
        }
    }

    public void bloquearConta(){
        if (statusConta36 == StatusConta36.ATIVA){
            statusConta36 = StatusConta36.BLOQUEADA;
            System.out.println(MensagensValidacaoConta36.CONTA_BLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta36.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta36 == StatusConta36.BLOQUEADA){
            statusConta36 = StatusConta36.ATIVA;
            System.out.println(MensagensValidacaoConta36.CONTA_DESBLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta36.ERRO_CONTA_DESBLOQUEADA.getDescricao());
    }

    public void cancelarConta(){
        if (statusConta36 == StatusConta36.ATIVA){
            if (saldo == MENOR_SALDO){
                statusConta36 = StatusConta36.CANCEADA;
                System.out.println(MensagensValidacaoConta36.CONTA_CANCELADA.getDescricao());
                return;
            }
            System.out.println(MensagensValidacaoConta36.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(MENOR_SALDO));
            return;
        }
        System.out.println(MensagensValidacaoConta36.ERRO_CONTA_CANCELADA.getDescricao());
    }

    public abstract void sacar(double valor);

    public void depositar(double valor){
        if (statusConta36 == StatusConta36.ATIVA){
            if (valor > MENOR_SALDO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta36.DEPOSITO.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoConta36.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(MENOR_SALDO));
            return;
        }
        System.out.println(MensagensValidacaoConta36.ERRO_DEPOSITO.getDescricao());
    }

    public void setCliente36(Cliente36 cliente36) {
        this.cliente36 = cliente36;
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

    public void setTipoConta36(TipoConta36 tipoConta36) {
        this.tipoConta36 = tipoConta36;
    }

    public void setStatusConta36(StatusConta36 statusConta36) {
        this.statusConta36 = statusConta36;
    }
    public enum TipoConta36{
        CORRENTE,POUPANÇA;
    }

    public enum StatusConta36{
        ATIVA, BLOQUEADA, CANCEADA;
    }

    public enum MensagensValidacaoConta36{
        DIGITOS_CONTA("Conta precisa ter %d digitos para ser validada."),
        CONTA_DUPLICADA("Conta duplicada. Verifique."),
        SALDO("Saldo não pode ser menor que R$%.2f."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status conta. Conta pode já esta bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada.Verifique saldo da conta. Saldo deve ser igual a R$%.2f."),
        DEPOSITO("Depósito realizado no valor de R$%.2f"),
        ERRO_DEPOSITO("Operção negada. Depósito não realizado. Verifique status da conta."),
        ERRO_VALOR_DEPOSITO("Operação negada. Verifique valor do depósito. Valor não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoConta36(String descricao) {
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
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo:R$%.2f |Tipo conta: %s |Status conta: %s",
                cliente36.getNome(),cliente36.getCpf(),numeroConta,saldo,tipoConta36,statusConta36);
    }
}
