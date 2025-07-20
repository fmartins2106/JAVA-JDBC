package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada38;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida38;
import academy.devdojo.maratonajava.javacore.excessoes.SaldoInvalido38;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta38 {
    protected Cliente38 cliente38;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta38 tipoConta38;
    protected StatusConta38 statusConta38;

    public Conta38(Cliente38 cliente38, int numeroConta, double saldo, TipoConta38 tipoConta38, StatusConta38 statusConta38) {
        this.cliente38 = cliente38;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta38 = tipoConta38;
        this.statusConta38 = statusConta38;
    }

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != NumeroContaInvalida38.DIGITOS_PADRAO_CONTA){
            throw new NumeroContaInvalida38();
        }
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new NumeroContaDuplicada38();
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SaldoInvalido38.SALDO_MINIMO){
            throw new SaldoInvalido38();
        }
    }

    public void bloquearConta(){
        if (statusConta38 == StatusConta38.ATIVA){
            statusConta38 = StatusConta38.BLOQUEADA;
            System.out.println(MensagensValidacaoConta38.CONTA_BLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta38.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta38 == StatusConta38.BLOQUEADA){
            statusConta38 = StatusConta38.ATIVA;
            System.out.println(MensagensValidacaoConta38.CONTA_DESBLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta38.ERRO_CONTA_DESBLOQUEADA.getDescricao());
    }

    public void cancelarConta(){
        if (statusConta38 == StatusConta38.ATIVA){
            if (saldo == SaldoInvalido38.SALDO_MINIMO){
                statusConta38 = StatusConta38.CANCELADA;
                System.out.println(MensagensValidacaoConta38.CONTA_CANCELADA.getDescricao());
                return;
            }
            System.out.println(MensagensValidacaoConta38.ERRO_VALOR_CONTA_CANCELADA.getDescricaoFormatada(SaldoInvalido38.SALDO_MINIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta38.ERRO_CONTA_CANCELADA.getDescricao());
    }

    public void depositar(double valor){
        if (statusConta38 == StatusConta38.ATIVA){
            if (valor > SaldoInvalido38.SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta38.DEPOSITO.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoConta38.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SaldoInvalido38.SALDO_MINIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta38.ERRO_DEPOSITO.getDescricao());
    }

    public abstract void sacar(double valor);

    public enum MensagensValidacaoConta38{
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        ERRO_VALOR_CONTA_CANCELADA("Operação negada.Saldo precisa ser igual a R$%.2f para efetuar o cancelamento da conta."),
        DEPOSITO("Deposito realizado no valor de R$%.2f"),
        ERRO_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor não pode ser menor que R$%.2f.");

        public final String descricao;

        MensagensValidacaoConta38(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta38{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta38{
        ATIVA, BLOQUEADA, CANCELADA;
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

    public void setTipoConta38(TipoConta38 tipoConta38) {
        this.tipoConta38 = tipoConta38;
    }

    public void setStatusConta38(StatusConta38 statusConta38) {
        this.statusConta38 = statusConta38;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s.",
                cliente38.getNome(),cliente38.getCpf(),numeroConta,saldo,tipoConta38,statusConta38);
    }
}
