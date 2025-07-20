package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.HashSet;
import java.util.Set;

public abstract class Conta19 {
    protected Cliente19 cliente19;
    protected int numeroConta;
    protected double saldo;
    protected Cliente19.TipoConta19 tipoConta19;
    protected Cliente19.StatusConta19 statusConta19;

    public Conta19(Cliente19 cliente19, int numeroConta, double saldo, Cliente19.TipoConta19 tipoConta19, Cliente19.StatusConta19 statusConta19) {
        this.cliente19 = cliente19;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta19 = tipoConta19;
        this.statusConta19 = statusConta19;
    }

    private static Set<Integer> listacontasCadastradas = new HashSet<>();

    public static final double SALDO_MINIMO = 0;
    public static final int QUANT_PADRAO_DIGITOS_CONTA = 6;

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != QUANT_PADRAO_DIGITOS_CONTA){
            throw new IllegalArgumentException(Cliente19.MensagensValidacaoCliente19.DIGITOS_CONTA.getDescricaoFormatada(QUANT_PADRAO_DIGITOS_CONTA));
        }
        if (listacontasCadastradas.contains(numeroConta)){
            throw new IllegalArgumentException(Cliente19.MensagensValidacaoCliente19.NUMERO_CONTA_CADASTRADA.getDescricao());
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente19.MensagensValidacaoCliente19.SALDO_MINIMO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta19 == Cliente19.StatusConta19.ATIVA){
            statusConta19 = Cliente19.StatusConta19.BLOQUEADA;
            System.out.println(Cliente19.MensagensValidacaoCliente19.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta19 == Cliente19.StatusConta19.BLOQUEADA){
            statusConta19 = Cliente19.StatusConta19.ATIVA;
            System.out.println(Cliente19.MensagensValidacaoCliente19.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void deposito(double valor){
        if (statusConta19 == Cliente19.StatusConta19.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println(Cliente19.MensagensValidacaoCliente19.DEPOSITO_REALIADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else{
            System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_STATUS_DEPOSITO.getDescricao());
        }
    }

    public void cancelamentoConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta19 == Cliente19.StatusConta19.ATIVA){
                statusConta19 = Cliente19.StatusConta19.CANCELADA;
                System.out.println(Cliente19.MensagensValidacaoCliente19.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_VALOR_CALCELAMENTO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public abstract void sacar(double valor);

    public Cliente19 getCliente19() {
        return cliente19;
    }

    public void setCliente19(Cliente19 cliente19) {
        this.cliente19 = cliente19;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
        listacontasCadastradas.add(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente19.TipoConta19 getTipoConta19() {
        return tipoConta19;
    }

    public void setTipoConta19(Cliente19.TipoConta19 tipoConta19) {
        this.tipoConta19 = tipoConta19;
    }

    public Cliente19.StatusConta19 getStatusConta19() {
        return statusConta19;
    }

    public void setStatusConta19(Cliente19.StatusConta19 statusConta19) {
        this.statusConta19 = statusConta19;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente19.getNome(),cliente19.getCpf(),numeroConta,saldo,tipoConta19,statusConta19);
    }

}
