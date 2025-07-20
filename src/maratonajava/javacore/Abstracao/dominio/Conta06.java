package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta06 {
    protected Cliente06 cliente06;
    protected int numeroConta;
    protected double saldo;
    protected Cliente06.TipoDaConta tipoDaConta;
    protected Cliente06.StatusDaConta statusDaConta;

    public Conta06(Cliente06 cliente06, int numeroConta, double saldo, Cliente06.TipoDaConta tipoDaConta, Cliente06.StatusDaConta statusDaConta) {
        this.cliente06 = cliente06;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoDaConta = tipoDaConta;
        this.statusDaConta = statusDaConta;
    }

    public Cliente06 getCliente06() {
        return cliente06;
    }

    public static final int DIGITOS_NUMERO_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        if (numeroConta < DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(Cliente06.Validation.ERRO_DIGITOS_CONTA.getDescricao());
        }
    }

    private void validacaoSaldoConta(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente06.Validation.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        this.statusDaConta = Cliente06.StatusDaConta.BLOQUEADA;
        System.out.println(Cliente06.Validation.BLOQUEIO_CONTA.getDescricao());
    }

    public void desbloquearConta(){
        if (this.statusDaConta == Cliente06.StatusDaConta.BLOQUEADA){
            this.statusDaConta = Cliente06.StatusDaConta.ATIVA;
            System.out.println("Conta desbloqueada com sucesso.");
        }else {
            System.out.println("Operação inválida, conta não está bloqueada.");
        }
    }

    public void encerrarConta(){
        if (saldo <= SALDO_MINIMO){
            this.statusDaConta = Cliente06.StatusDaConta.CANCELADA;
            System.out.println(Cliente06.Validation.CONTA_CANCELADA.getDescricao());
        }else {
            System.out.println(Cliente06.Validation.ERRO_CANCELAMENTO.getDescricao());
        }
    }

    public void depositar(double valor){
        if (this.statusDaConta != Cliente06.StatusDaConta.ATIVA){
            System.out.println(Cliente06.Validation.CONTA_INATIVA.getDescricao());
        }else {
            if (valor > SALDO_MINIMO){
                saldo += valor;
                System.out.println("Deposito realizado no valor de R$"+valor);
            }else {
                System.out.println("Valor inválido.");
            }
        }
    }

    public abstract void saque(double valor);

    public void setCliente06(Cliente06 cliente06) {
        this.cliente06 = cliente06;
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
        validacaoSaldoConta(saldo);
        this.saldo = saldo;
    }

    public Cliente06.TipoDaConta getTipoDaConta() {
        return tipoDaConta;
    }

    public void setTipoDaConta(Cliente06.TipoDaConta tipoDaConta) {
        this.tipoDaConta = tipoDaConta;
    }

    public Cliente06.StatusDaConta getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(Cliente06.StatusDaConta statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Numero conta: %d |Saldo %.2f |Tipo conta: %s |Status conta: %s",
                cliente06.getNome(),cliente06.getCpf(),numeroConta,saldo,tipoDaConta,statusDaConta);
    }
}
