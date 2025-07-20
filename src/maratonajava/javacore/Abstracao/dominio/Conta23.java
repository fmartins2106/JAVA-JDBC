package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta23 {
    protected Cliente23 cliente23;
    protected int numeroConta;
    protected double saldo;
    protected Cliente23.TipoConta23 tipoConta23;
    protected Cliente23.StatusConta23 statusConta23;

    public Conta23(Cliente23 cliente23, int numeroConta, double saldo, Cliente23.TipoConta23 tipoConta23, Cliente23.StatusConta23 statusConta23) {
        this.cliente23 = cliente23;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta23 = tipoConta23;
        this.statusConta23 = statusConta23;
    }

    public static final int DIGITOS_PADRAO_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_PADRAO_CONTA){
            throw new IllegalArgumentException(Cliente23.MensagensValidacaoCliente23.ERRO_DIGITOS_CONTA.getDescricaoFormadata(DIGITOS_PADRAO_CONTA));
        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente23.MensagensValidacaoCliente23.ERRO_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta23 == Cliente23.StatusConta23.ATIVA){
            statusConta23 = Cliente23.StatusConta23.BLOQUEADA;
            System.out.println(Cliente23.MensagensValidacaoCliente23.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta23 == Cliente23.StatusConta23.BLOQUEADA){
            statusConta23 = Cliente23.StatusConta23.ATIVA;
            System.out.println(Cliente23.MensagensValidacaoCliente23.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelamentoConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta23 == Cliente23.StatusConta23.ATIVA){
                statusConta23 = Cliente23.StatusConta23.CANCELADA;
                System.out.println(Cliente23.MensagensValidacaoCliente23.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente23.MensagensValidacaoCliente23.ERR_CONTA_CANCELADA_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void depositar(double valor){
        if (statusConta23 == Cliente23.StatusConta23.ATIVA){
            if (valor >= saldo){
                saldo+=valor;
                System.out.println(Cliente23.MensagensValidacaoCliente23.DEPOSITO_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_VALOR_DEPOSITO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_STATUS_DEPOSITO.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente23 getCliente23() {
        return cliente23;
    }

    public void setCliente23(Cliente23 cliente23) {
        this.cliente23 = cliente23;
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

    public Cliente23.TipoConta23 getTipoConta23() {
        return tipoConta23;
    }

    public void setTipoConta23(Cliente23.TipoConta23 tipoConta23) {
        this.tipoConta23 = tipoConta23;
    }

    public Cliente23.StatusConta23 getStatusConta23() {
        return statusConta23;
    }

    public void setStatusConta23(Cliente23.StatusConta23 statusConta23) {
        this.statusConta23 = statusConta23;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente23.getNome(),cliente23.getCpf(),numeroConta,saldo,tipoConta23,statusConta23);
    }
}
