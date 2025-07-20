package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta12 {
    protected Cliente12 cliente12;
    protected int numeroConta;
    protected double saldo;
    protected Cliente12.TipoConta12 tipoConta12;
    protected Cliente12.StatusConta12 statusConta12;

    public Conta12(Cliente12 cliente12, int numeroConta, double saldo, Cliente12.TipoConta12 tipoConta12, Cliente12.StatusConta12 statusConta12) {
        this.cliente12 = cliente12;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta12 = tipoConta12;
        this.statusConta12 = statusConta12;
    }

    public static final double SALDO_MINIMO = 0;
    public static final int DIGITOS_CONTA = 6;

    private void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(Cliente12.ValidanacaoErrosCliente12.ERRO_DIGITOS_CONTA.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente12.ValidanacaoErrosCliente12.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        statusConta12 = Cliente12.StatusConta12.BLOQUEADA;
        System.out.println(Cliente12.ValidanacaoErrosCliente12.CONTA_BLOQUEADA.getDescricao());
    }

    public void encerrarConta(){
        if (saldo == SALDO_MINIMO){
            statusConta12 = Cliente12.StatusConta12.CANCELADA;
        }else {
            System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_CANCELAMENTO_CONTA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta12 == Cliente12.StatusConta12.BLOQUEADA){
            statusConta12 = Cliente12.StatusConta12.ATIVA;
            System.out.println(Cliente12.ValidanacaoErrosCliente12.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            if (statusConta12 == Cliente12.StatusConta12.ATIVA){
                System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_DESBLOQUEIO_ATIVA.getDescricao());
            }else {
                System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_DESBLOQUEIO_CANCELADA.getDescricao());
            }
        }
    }


    public void deposito(double valor){
        if (statusConta12 != Cliente12.StatusConta12.ATIVA){
            System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_DEPOSITO.getDescricao());
        }else {
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println(Cliente12.ValidanacaoErrosCliente12.DEPOSITO.getDescricao());
            }else {
                System.out.println(Cliente12.ValidanacaoErrosCliente12.DEPOSITO_VALOR_INVALIDO.getDescricao());
            }
        }
    }

    public abstract void sacar(double valor);




    public Cliente12 getCliente12() {
        return cliente12;
    }

    public void setCliente12(Cliente12 cliente12) {
        this.cliente12 = cliente12;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente12.TipoConta12 getTipoConta12() {
        return tipoConta12;
    }

    public void setTipoConta12(Cliente12.TipoConta12 tipoConta12) {
        this.tipoConta12 = tipoConta12;
    }

    public Cliente12.StatusConta12 getStatusConta12() {
        return statusConta12;
    }

    public void setStatusConta12(Cliente12.StatusConta12 statusConta12) {
        this.statusConta12 = statusConta12;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente12.getNome(),cliente12.getCpf(),numeroConta,saldo,tipoConta12,statusConta12);
    }
}
