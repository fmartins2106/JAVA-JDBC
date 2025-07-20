package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta14 {
    protected Cliente14 cliente14;
    protected int numeroConta;
    protected double saldo;
    protected Cliente14.TipoConta14 tipoConta14;
    protected Cliente14.StatusConta14 statusConta14;

    public Conta14(Cliente14 cliente14, int numeroConta, double saldoInicial, Cliente14.TipoConta14 tipoConta14, Cliente14.StatusConta14 statusConta14) {
        this.cliente14 = cliente14;
        setNumeroConta(numeroConta);
        atualizarSaldo(saldoInicial);
        this.tipoConta14 = tipoConta14;
        this.statusConta14 = statusConta14;
    }

    public static final int DIGITOS_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if ( numeroContaStr.length() != DIGITOS_CONTA ){
            throw new IllegalArgumentException(Cliente14.MensagensErroCliente14.VALIDACAO_DIGITOS_CONTA.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente14.MensagensErroCliente14.VALIDACAO_SALDO_MINIMO.getDescricao());
        }
    }

    protected void atualizarSaldo(double novoSaldo){
        validacaoSaldo(novoSaldo);
        this.saldo = novoSaldo;
    }

    public void bloquearConta(){
        if (statusConta14 == Cliente14.StatusConta14.ATIVA){
            statusConta14 = Cliente14.StatusConta14.BLOQUEADA;
            System.out.println(Cliente14.MensagensErroCliente14.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente14.MensagensErroCliente14.CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta14 == Cliente14.StatusConta14.BLOQUEADA){
            statusConta14 = Cliente14.StatusConta14.ATIVA;
            System.out.println(Cliente14.MensagensErroCliente14.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente14.MensagensErroCliente14.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void encerrarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta14 == Cliente14.StatusConta14.ATIVA){
                statusConta14 = Cliente14.StatusConta14.CANCELADA;
                System.out.println(Cliente14.MensagensErroCliente14.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente14.MensagensErroCliente14.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente14.MensagensErroCliente14.ERRO_CONTA_CANCELADA2.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusConta14 == Cliente14.StatusConta14.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println("Deposito de R$ "+valor+" realizado com sucesso.");
            }else {
                System.out.println(Cliente14.MensagensErroCliente14.ERRO_DEPOSITO.getDescricao());
            }
        }else {
            System.out.println(Cliente14.MensagensErroCliente14.ERRO_DEPOSITO2.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente14 getCliente14() {
        return cliente14;
    }

    public void setCliente14(Cliente14 cliente14) {
        this.cliente14 = cliente14;
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
        atualizarSaldo(saldo);
    }

    public Cliente14.TipoConta14 getTipoConta14() {
        return tipoConta14;
    }

    public void setTipoConta14(Cliente14.TipoConta14 tipoConta14) {
        this.tipoConta14 = tipoConta14;
    }

    public Cliente14.StatusConta14 getStatusConta14() {
        return statusConta14;
    }

    public void setStatusConta14(Cliente14.StatusConta14 statusConta14) {
        this.statusConta14 = statusConta14;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente14.getNome(),cliente14.getCpf(),numeroConta,saldo,tipoConta14, statusConta14);
    }

}
