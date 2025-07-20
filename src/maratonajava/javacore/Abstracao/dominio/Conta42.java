package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada42;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida42;
import academy.devdojo.maratonajava.javacore.excessoes.SaldoInvalido42;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta42 {
    protected  Cliente42 cliente42;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta42 tipoConta42;
    protected StatusConta42 statusConta42;

    public Conta42(Cliente42 cliente42, int numeroConta, double saldo, TipoConta42 tipoConta42, StatusConta42 statusConta42) {
        this.cliente42 = cliente42;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta42 = tipoConta42;
        this.statusConta42 = statusConta42;
    }

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContastr = String.valueOf(numeroConta);
        if (numeroContastr.length() != NumeroContaInvalida42.DIGITOS_CONTA){
            throw new NumeroContaInvalida42();
        }
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();
    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new NumeroContaDuplicada42();
        }
    }

    public abstract void sacar(double valor);

    public void bloquearConta(){
        if (statusConta42 == StatusConta42.ATIVA){
            statusConta42 = StatusConta42.BLOQUEADA;
            System.out.println(MensagensValidacaoConta42.CONTA_BLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta42.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta42 == StatusConta42.BLOQUEADA){
            statusConta42 = StatusConta42.ATIVA;
            System.out.println(MensagensValidacaoConta42.CONTA_DESBLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta42.ERRO_CONTA_DESBLOQUEADA.getDescricao());
    }

    public void cancelarConta(){
        if (statusConta42 == StatusConta42.ATIVA){
            if (saldo == SaldoInvalido42.MENOR_SALDO_PERMITIDO){
                statusConta42 = StatusConta42.CANCELADA;
                System.out.println(MensagensValidacaoConta42.CONTA_CANCELADA.getDescricao());
                return;
            }
            System.out.println(MensagensValidacaoConta42.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SaldoInvalido42.MENOR_SALDO_PERMITIDO));
            return;
        }
        System.out.println(MensagensValidacaoConta42.ERRO_CONTA_CANCELADA.getDescricao());
    }


    public void depositar(double valor){
        if (statusConta42 == StatusConta42.ATIVA){
            if (valor > SaldoInvalido42.MENOR_SALDO_PERMITIDO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta42.DEPOSITO.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoConta42.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SaldoInvalido42.MENOR_SALDO_PERMITIDO));
            return;
        }
        System.out.println(MensagensValidacaoConta42.ERRO_DEPOSITO.getDescricao());
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SaldoInvalido42.MENOR_SALDO_PERMITIDO){
            throw new SaldoInvalido42();
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

    public void setTipoConta42(TipoConta42 tipoConta42) {
        this.tipoConta42 = tipoConta42;
    }

    public void setStatusConta42(StatusConta42 statusConta42) {
        this.statusConta42 = statusConta42;
    }

    public enum TipoConta42{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta42{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    public enum MensagensValidacaoConta42{
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada, verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Para efetuar o cancelamento da conta, saldo precisa ser igual a R$%.2f."),
        DEPOSITO("Depósito realizado no valor de R$%.2f."),
        ERRO_DEPOSITO("Operação negada. verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor não pode ser menor ou igual a R$%.2f.");

        private final String descricao;

        MensagensValidacaoConta42(String descricao) {
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
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo:R$%.2f |Tipo conta: %s |Status conta: %s",
                cliente42.getNome(),cliente42.getCpf(),this.numeroConta,this.saldo,this.tipoConta42, this.statusConta42);
    }
}
