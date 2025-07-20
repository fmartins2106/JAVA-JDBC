package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada40;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida40;
import academy.devdojo.maratonajava.javacore.excessoes.SaldoInvalido40;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Conta40 {
    protected Cliente40 cliente40;
    protected int numeroConta;
    protected double saldo;
    protected TipoConta40 tipoConta40;
    protected StatusConta40 statusConta40;

    public Conta40(Cliente40 cliente40, int numeroConta, double saldo, TipoConta40 tipoConta40, StatusConta40 statusConta40) {
        this.cliente40 = cliente40;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta40 = tipoConta40;
        this.statusConta40 = statusConta40;
    }

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != NumeroContaInvalida40.DIGITOS_CONTA){
            throw new NumeroContaInvalida40();
        }
    }

    public static Set<Integer> contasCadastradas = new HashSet<>();

    public static void validacaoNumeroContaDuplicada(int numeroConta){
        if (contasCadastradas.contains(numeroConta)){
            throw new NumeroContaDuplicada40();
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SaldoInvalido40.SALDO_MINIMO){
            throw new SaldoInvalido40();
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

    public enum TipoConta40{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta40{
        ATIVA, BLOQUEADA, CANCELADA;
    }

    public void bloquearConta(){
        if (statusConta40 == StatusConta40.ATIVA){
            statusConta40 = StatusConta40.BLOQUEADA;
            System.out.println(MensagensValidacaoConta40.CONTA_BLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta40.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta40 == StatusConta40.BLOQUEADA){
            statusConta40 = StatusConta40.ATIVA;
            System.out.println(MensagensValidacaoConta40.CONTA_DESBLOQUEADA.getDescricao());
            return;
        }
        System.out.println(MensagensValidacaoConta40.ERRO_CONTA_DESBLOQUEADA.getDescricao());
    }

    public void cancelarConta(){
        if (statusConta40 == StatusConta40.ATIVA){
            if (saldo == SaldoInvalido40.SALDO_MINIMO){
                statusConta40 = StatusConta40.CANCELADA;
                System.out.println(MensagensValidacaoConta40.CONTA_CANCELADA.getDescricao());
                return;
            }
            System.out.println(MensagensValidacaoConta40.ERRO_VALOR_CONTA_CANCELADA.getDescricaoFormatada(SaldoInvalido40.SALDO_MINIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta40.ERRO_CONTA_CANCELADA.getDescricao());
    }

    public abstract void sacar(double valor);

    public void depositar(double valor){
        if (statusConta40 == StatusConta40.ATIVA){
            if (valor > SaldoInvalido40.SALDO_MINIMO){
                saldo += valor;
                System.out.println(MensagensValidacaoConta40.DEPOSITO.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoConta40.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SaldoInvalido40.SALDO_MINIMO));
            return;
        }
        System.out.println(MensagensValidacaoConta40.ERRO_DEPOSITO.getDescricao());
    }

    public enum MensagensValidacaoConta40{
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta pode já estar cancelada ou bloqueada."),
        ERRO_VALOR_CONTA_CANCELADA("Operação negada. Para efetuar cancelamento da conta. Saldo precisa ser igual a R$%.2f."),
        DEPOSITO("Depósito realizado no valor de R$%.2f"),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor do depósito deve ser maior que R$%.2f."),
        ERRO_DEPOSITO("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada.");

        private final String descricao;

        MensagensValidacaoConta40(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo:R$ %.2f |Tipo conta: %s |Status conta: %s",
                cliente40.getNome(),cliente40.getCpf(),numeroConta,saldo,tipoConta40,statusConta40);
    }
}
