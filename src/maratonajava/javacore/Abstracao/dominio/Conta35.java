package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta35 {
    protected Cliente35 cliente35;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta35 tipoConta35;
    protected StatusConta35 statusConta35;

    public Conta35(Cliente35 cliente35, int numeroConta, double saldo, TipoConta35 tipoConta35, StatusConta35 statusConta35) {
        this.cliente35 = cliente35;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta35 = tipoConta35;
        this.statusConta35 = statusConta35;
    }

    private static final int DIGITOS_NUMERO_CONTA = 6;

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(MensagensValidacaoConta35.NUMERO_CONTA.getDescricaoFormatada(DIGITOS_NUMERO_CONTA));
        }
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(MensagensValidacaoConta35.NUMERO_CONTA_DUPLICADA.getDescricao());
        }
    }

    private static final double MENOR_SALDO = 0;

    public static void validacaoSaldo(double saldo){
        if (saldo < MENOR_SALDO){
            throw new IllegalArgumentException(MensagensValidacaoConta35.SALDO.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta35 == StatusConta35.ATIVA){
            statusConta35 = StatusConta35.BLOQUEADA;
            System.out.println(MensagensValidacaoConta35.CONTA_BLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta35.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta35 == StatusConta35.BLOQUEADA){
            statusConta35 = StatusConta35.ATIVA;
            System.out.println(MensagensValidacaoConta35.CONTA_DESBLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta35.ERRO_CONTA_DESBLOQUEADA.getDescricao());
    }

    public void cancelarConta(){
        if (statusConta35 == StatusConta35.ATIVA){
            if (saldo == MENOR_SALDO){
                System.out.println(MensagensValidacaoConta35.CONTA_CANCELADA.getDescricao());
                return;
            }
            System.out.println(MensagensValidacaoConta35.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(MENOR_SALDO));
            return;
        }
        System.out.println(MensagensValidacaoConta35.ERRO_CONTA_CANCELADA.getDescricao());
    }

    public void depositar(double valor){
        if (statusConta35 == StatusConta35.ATIVA){
            if (valor > MENOR_SALDO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta35.DEPOSITO.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoConta35.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(MENOR_SALDO));
            return;
        }
        System.out.println(MensagensValidacaoConta35.ERRO_DEPOSITO.getDescricao());
    }


    public void setCliente35(Cliente35 cliente35) {
        this.cliente35 = cliente35;
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

    public enum TipoConta35{
        CORRENTE,POUPANÇA;
    }

    public enum StatusConta35{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    public enum MensagensValidacaoConta35{
        NUMERO_CONTA("Número da conta precisa ter %d digitos."),
        NUMERO_CONTA_DUPLICADA("Número de conta duplicada."),
        SALDO("Saldo não pode ser menor que R$%.2f."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada, verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já esta cencelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Saldo precisa ser igual a R$%.2f."),
        DEPOSITO("Depósito no valor de R$%.2f realizado com sucesso."),
        ERRO_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_DEPOSITO("Operação negada. Verifique valor. Valor não pode ser menor que R$%.2f.");


        private final String descricao;

        MensagensValidacaoConta35(String descricao) {
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
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente35.getNome(),cliente35.getCpf(),numeroConta,saldo,tipoConta35,statusConta35);
    }

}
