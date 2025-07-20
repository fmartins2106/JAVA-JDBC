package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta15 {
    protected Cliente15 cliente15;
    protected int numeroConta;
    protected double saldo;
    protected Cliente15.TipoConta15 tipoConta15;
    protected Cliente15.StatusConta15 statusConta15;

    public Conta15(Cliente15 cliente15, int numeroConta, double saldo, Cliente15.TipoConta15 tipoConta15, Cliente15.StatusConta15 statusConta15) {
        this.cliente15 = cliente15;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta15 = tipoConta15;
        this.statusConta15 = statusConta15;
    }

    public static final int DIGITOS_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(Cliente15.MensagensErroCliente15.DIGITOS_CONTA.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo != SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente15.MensagensErroCliente15.SALDO_MINIMO.getDescricao());
        }
    }

    public void bloquearConta(){
        if (statusConta15 == Cliente15.StatusConta15.ATIVA){
            statusConta15 = Cliente15.StatusConta15.BLOQUEADA;
            System.out.println(Cliente15.MensagensErroCliente15.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente15.MensagensErroCliente15.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta15 == Cliente15.StatusConta15.BLOQUEADA){
            statusConta15 = Cliente15.StatusConta15.ATIVA;
            System.out.println(Cliente15.MensagensErroCliente15.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente15.MensagensErroCliente15.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta15 == Cliente15.StatusConta15.ATIVA){
                statusConta15 = Cliente15.StatusConta15.CANCELADA;
                System.out.println(Cliente15.MensagensErroCliente15.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente15.MensagensErroCliente15.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente15.MensagensErroCliente15.ERRO_SALDO_CONTA_CANCELADA.getDescricao());
        }
    }

    public void deposito(double valor){
        if (statusConta15 == Cliente15.StatusConta15.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println("Deposito de R$"+valor+" realizado com sucesso.");
            }else {
                System.out.println(Cliente15.MensagensErroCliente15.ERRO_DEPOSITO_VALOR_INVALIDO.getDescricao());
            }
        }else {
            System.out.println(Cliente15.MensagensErroCliente15.ERRO_DEPOSITO_CONTA_INATIVA.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente15 getCliente15() {
        return cliente15;
    }

    public void setCliente15(Cliente15 cliente15) {
        this.cliente15 = cliente15;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoConta(numeroConta);
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente15.TipoConta15 getTipoConta15() {
        return tipoConta15;
    }

    public void setTipoConta15(Cliente15.TipoConta15 tipoConta15) {
        this.tipoConta15 = tipoConta15;
    }

    public Cliente15.StatusConta15 getStatusConta15() {
        return statusConta15;
    }

    public void setStatusConta15(Cliente15.StatusConta15 statusConta15) {
        this.statusConta15 = statusConta15;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente15.getNome(),cliente15.getCpf(),numeroConta,saldo,tipoConta15,statusConta15);
    }


}
