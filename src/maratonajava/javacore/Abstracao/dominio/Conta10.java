package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta10 {
    protected Cliente10 cliente10;
    protected int numeroConta;
    protected double saldo;
    protected Cliente10.TipoConta10 tipoConta10;
    protected Cliente10.StatusConta10 statusConta10;

    public Conta10(Cliente10 cliente10, int numeroConta, double saldo, Cliente10.TipoConta10 tipoConta10, Cliente10.StatusConta10 statusConta10) {
        this.cliente10 = cliente10;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta10 = tipoConta10;
        this.statusConta10 = statusConta10;
    }

    public static final int DIGITOS_PADRAO_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_PADRAO_CONTA){
            throw new IllegalArgumentException(Cliente10.ErrosValidados.ERRO_NUMERO_CONTA.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente10.ErrosValidados.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        statusConta10 = Cliente10.StatusConta10.BLOQUEADA;
        System.out.println(Cliente10.ErrosValidados.CONTA_BLOQUERADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta10 == Cliente10.StatusConta10.BLOQUEADA){
            statusConta10 = Cliente10.StatusConta10.ATIVA;
            System.out.println(Cliente10.ErrosValidados.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            if (statusConta10 == Cliente10.StatusConta10.CANCELADA){
                System.out.println(Cliente10.ErrosValidados.ERRO_CONTA_DESBLOQUEADA.getDescricao());
            }else {
                System.out.println(Cliente10.ErrosValidados.ERRO_CONTA_DESBLOQUEADA.getDescricao());
            }
        }
    }

    public void encerrarConta(){
        if (saldo == SALDO_MINIMO){
            statusConta10 = Cliente10.StatusConta10.CANCELADA;
            System.out.println(Cliente10.ErrosValidados.CONTA_CANCELADA.getDescricao());
        }else {
            System.out.println(Cliente10.ErrosValidados.ERRO_CANCELAMENTO_CONTA.getDescricao());
        }
    }

    public void deposito(double valor){
        if (statusConta10 != Cliente10.StatusConta10.ATIVA){
            System.out.println(Cliente10.ErrosValidados.PERMISSAO_DEPOSITO.getDescricao());
        }else {
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println("Deposito de R$"+valor+" efetuado com sucesso.");
            }else {
                System.out.println(Cliente10.ErrosValidados.ERRO_DEPOSITO.getDescricao());
            }
        }
    }

    public abstract void transferencia(double valor);

    public Cliente10 getCliente10() {
        return cliente10;
    }

    public void setCliente10(Cliente10 cliente10) {
        this.cliente10 = cliente10;
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

    public Cliente10.TipoConta10 getTipoConta10() {
        return tipoConta10;
    }

    public void setTipoConta10(Cliente10.TipoConta10 tipoConta10) {
        this.tipoConta10 = tipoConta10;
    }

    public Cliente10.StatusConta10 getStatusConta10() {
        return statusConta10;
    }

    public void setStatusConta10(Cliente10.StatusConta10 statusConta10) {
        this.statusConta10 = statusConta10;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente10.getNome(),cliente10.getCpf(),numeroConta,saldo,tipoConta10,statusConta10);
    }
}
