package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta13 {
    protected Cliente13 cliente13;
    protected int numeroConta;
    protected double saldo;
    protected Cliente13.TipoConta13 tipoConta13;
    protected Cliente13.StatusConta13 statusConta13;

    public Conta13(Cliente13 cliente13, int numeroConta, double saldo, Cliente13.TipoConta13 tipoConta13, Cliente13.StatusConta13 statusConta13) {
        this.cliente13 = cliente13;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta13 = tipoConta13;
        this.statusConta13 = statusConta13;
    }

    public static final double SALDO_MINIMO_PERMITIDO = 0;
    public static final int PADRAO_DIGITOS_CONTA = 6;

    private void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != PADRAO_DIGITOS_CONTA){
            throw new IllegalArgumentException(Cliente13.MensagensValidacaoCliente13.PADRAO_DIGITOS_CONTA.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO_PERMITIDO){
            throw new IllegalArgumentException(Cliente13.MensagensValidacaoCliente13.SALDO_MINIMO_PERMITIDO.getDescricao());
        }
    }

    public void bloquearConta(){
        if (statusConta13 == Cliente13.StatusConta13.ATIVA){
            statusConta13 = Cliente13.StatusConta13.BLOQUEADA;
            System.out.println("Conta bloqueada com sucesso.");
        }else {
            if (statusConta13 == Cliente13.StatusConta13.BLOQUEADA){
                System.out.println(Cliente13.MensagensValidacaoCliente13.ERRO_CONTA_BLOQUEADA.getDescricao());
            }else {
                System.out.println(Cliente13.MensagensValidacaoCliente13.ERRO_CONTA_BLOQUEADA2.getDescricao());
            }
        }
    }

    public void desbloquearConta(){
        if (statusConta13 == Cliente13.StatusConta13.BLOQUEADA){
            statusConta13 = Cliente13.StatusConta13.ATIVA;
            System.out.println(Cliente13.MensagensValidacaoCliente13.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            if (statusConta13 == Cliente13.StatusConta13.ATIVA){
                System.out.println(Cliente13.MensagensValidacaoCliente13.CONTA_DESBLOQUEADA.getDescricao());
            }else {
                System.out.println(Cliente13.MensagensValidacaoCliente13.ERRO_CONTA_BLOQUEADA2.getDescricao());
            }
        }
    }

    public void encerrarConta(){
        if (saldo == SALDO_MINIMO_PERMITIDO){
            if (statusConta13 != Cliente13.StatusConta13.CANCELADA){
                System.out.println(Cliente13.MensagensValidacaoCliente13.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente13.MensagensValidacaoCliente13.ERRO_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente13.MensagensValidacaoCliente13.ERRO_CANCELADA2.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusConta13 == Cliente13.StatusConta13.ATIVA){
            if (valor > SALDO_MINIMO_PERMITIDO){
                saldo+=valor;
                System.out.println("Deposito no valor de R$"+valor+" realizado com sucesso.");
            }else {
                System.out.println("Valor inválido.");
            }
        }else {
            System.out.println(Cliente13.MensagensValidacaoCliente13.ERRO_DEPOSITO.getDescricao());
        }
    }


    public abstract void sacar(double valor);

    public Cliente13 getCliente13() {
        return cliente13;
    }

    public void setCliente13(Cliente13 cliente13) {
        this.cliente13 = cliente13;
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

    public Cliente13.TipoConta13 getTipoConta13() {
        return tipoConta13;
    }

    public void setTipoConta13(Cliente13.TipoConta13 tipoConta13) {
        this.tipoConta13 = tipoConta13;
    }

    public Cliente13.StatusConta13 getStatusConta13() {
        return statusConta13;
    }

    public void setStatusConta13(Cliente13.StatusConta13 statusConta13) {
        this.statusConta13 = statusConta13;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente13.getNome(), cliente13.getCpf(), numeroConta,saldo,tipoConta13,statusConta13);
    }

}
