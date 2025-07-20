package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.NumercContaDuplicada37;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida37;
import academy.devdojo.maratonajava.javacore.excessoes.SaldoInvalido37;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta37 {
    protected Cliente37 cliente37;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta37 tipoConta37;
    protected StatusConta37 statusConta37;

    public Conta37(Cliente37 cliente37, int numeroConta, double saldo, TipoConta37 tipoConta37, StatusConta37 statusConta37) {
        this.cliente37 = cliente37;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta37 = tipoConta37;
        this.statusConta37 = statusConta37;
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new NumercContaDuplicada37();
        }
    }

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != NumeroContaInvalida37.DIGITOS_PADRAO_CONTA){
            throw new NumeroContaInvalida37();
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SaldoInvalido37.SALDO_NIMIMO){
            throw new SaldoInvalido37();
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

    public abstract void sacar(double valor);

    public void cancelarConta(){
        if (statusConta37 == StatusConta37.ATIVA){
            if (saldo == SaldoInvalido37.SALDO_NIMIMO){
                statusConta37 = StatusConta37.CANCELADA;
                System.out.println(MensagensValidacaoConta37.CONTA_CANCELADA.getDescricao());
                return;
            }
            System.out.println(MensagensValidacaoConta37.ERRO_SALDO_CONTA_CANCELADA.getDescricaoFormatada(SaldoInvalido37.SALDO_NIMIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta37.ERRO_CONTA_CANCELADA.getDescricao());
    }

    public void bloquearConta(){
        if (statusConta37 == StatusConta37.ATIVA){
            statusConta37 = StatusConta37.BLOQUEADA;
            System.out.println(MensagensValidacaoConta37.CONTA_BLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta37.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta37 == StatusConta37.BLOQUEADA){
            statusConta37 = StatusConta37.ATIVA;
            System.out.println(MensagensValidacaoConta37.CONTA_DESBLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta37.ERRO_CONTA_DESBLOQUEADA.getDescricao());
    }

    public void depositar(double valor){
        if (statusConta37 == StatusConta37.ATIVA){
            if (valor > SaldoInvalido37.SALDO_NIMIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta37.DEPOSITO.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoConta37.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SaldoInvalido37.SALDO_NIMIMO));
        }
        System.out.println(MensagensValidacaoConta37.ERRO_DEPOSITO.getDescricao());
    }

    public enum MensagensValidacaoConta37{
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já esta cancelada ou bloqueada."),
        ERRO_SALDO_CONTA_CANCELADA("Operação negada. Para efetuar cancelamento da conta, saldo precisa ser igual a R$%.2f"),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        DEPOSITO("Depósito realizado no valor de R$%.2f."),
        ERRO_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_DEPOSITO("Operação negada. Verifique valor do depósito. Não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoConta37(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta37{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta37{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente37.getNome(),cliente37.getCpf(),numeroConta,saldo,tipoConta37,statusConta37);
    }
}
