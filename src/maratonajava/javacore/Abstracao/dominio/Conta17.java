package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta17 {
    protected Cliente17 cliente17;
    protected int numeroConta;
    protected double saldo;
    protected Cliente17.TipoConta17 tipoConta17;
    protected Cliente17.StatusConta17 statusConta17;

    public Conta17(Cliente17 cliente17, int numeroConta, double saldo, Cliente17.TipoConta17 tipoConta17, Cliente17.StatusConta17 statusConta17) {
        this.cliente17 = cliente17;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta17 = tipoConta17;
        this.statusConta17 = statusConta17;
    }

    public static final int DIGITOS_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    public static void validacaoConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(Cliente17.MensagemValidacaoCliente17.ERRO_DIGITOS_CONTA.getDescricao());
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente17.MensagemValidacaoCliente17.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        if (statusConta17 == Cliente17.StatusConta17.ATIVA){
            statusConta17 = Cliente17.StatusConta17.BLOQUEADA;
            System.out.println(Cliente17.MensagemValidacaoCliente17.CONTA_CANCELADA.getDescricao());
        }else {
            System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta17 == Cliente17.StatusConta17.BLOQUEADA){
            statusConta17 = Cliente17.StatusConta17.ATIVA;
            System.out.println(Cliente17.MensagemValidacaoCliente17.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta17 == Cliente17.StatusConta17.ATIVA){
                statusConta17 = Cliente17.StatusConta17.CANCELADA;
                System.out.println(Cliente17.MensagemValidacaoCliente17.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente16.MensagensValidacaoCliente16.ERR0_CONTA_CANCELADA2.getDescricao());
        }
    }

    public void depositar(Double valor){
        if (statusConta17 == Cliente17.StatusConta17.ATIVA){
            if (valor > SALDO_MINIMO) {
                saldo += valor;
                System.out.println(Cliente17.MensagemValidacaoCliente17.DEPOSITO.getDescricaoFortatada(valor));
            }else {
                System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_VALOR_DEPOSITO.getDescricao());
            }
        }else {
            System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_STATUS_DEPOSITO.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente17 getCliente17() {
        return cliente17;
    }

    public void setCliente17(Cliente17 cliente17) {
        this.cliente17 = cliente17;
    }

    public int getNumeroConta() {
        validacaoConta(numeroConta);
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente17.TipoConta17 getTipoConta17() {
        return tipoConta17;
    }

    public void setTipoConta17(Cliente17.TipoConta17 tipoConta17) {
        this.tipoConta17 = tipoConta17;
    }

    public Cliente17.StatusConta17 getStatusConta17() {
        return statusConta17;
    }

    public void setStatusConta17(Cliente17.StatusConta17 statusConta17) {
        this.statusConta17 = statusConta17;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente17.getNome(),cliente17.getCpf(),numeroConta,saldo, tipoConta17,statusConta17);
    }
}
