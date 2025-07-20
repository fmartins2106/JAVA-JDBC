package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta04 {
    protected Cliente04 cliente04;
    protected int numeroConta;
    protected double saldo;
    protected Cliente04.TipoConta tipoConta;
    protected Cliente04.StatusConta statusConta;

    public Conta04(Cliente04 cliente04, int numeroConta, double saldo, Cliente04.TipoConta tipoConta, Cliente04.StatusConta statusConta) {
        this.cliente04 = cliente04;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta = tipoConta;
        this.statusConta = statusConta;
    }

    public static final int DIGITOS_NUMERO_CONTA = 6;
    public static final double SALDO_MINIMO_CONTA = 0;

    private void validacaoNumeroConta(int numeroConta){
        if (numeroConta < DIGITOS_NUMERO_CONTA){
            throw new IllegalArgumentException(Cliente04.ValidacaoDescricao.ERRO_CONTA.getDescricao());
        }
    }

    private void validacaoSaldoConta(double saldo){
        if (saldo < SALDO_MINIMO_CONTA){
            throw new IllegalArgumentException(Cliente04.ValidacaoDescricao.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        this.statusConta = Cliente04.StatusConta.BLOQUEADA;
        System.out.println(Cliente04.ValidacaoDescricao.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (this.statusConta == Cliente04.StatusConta.BLOQUEADA){
            this.statusConta = Cliente04.StatusConta.ATIVA;
            System.out.println("Conta desbloqueada com sucesso.");
        }else {
            System.out.println("A conta não está bloqueada.");
        }
    }

    public void encerrarConta(){
        if (saldo <= SALDO_MINIMO_CONTA){
            this.statusConta = Cliente04.StatusConta.CANCELADA;
            System.out.println(Cliente04.ValidacaoDescricao.ERRO_CONTA_ENCERRADA.getDescricao());
        }else {
            System.out.println(Cliente04.ValidacaoDescricao.ERR_CANCELAR_CONTA.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusConta != Cliente04.StatusConta.ATIVA){
            System.out.println(Cliente04.ValidacaoDescricao.ERRO_CONTA_INATIVA.getDescricao());
        }else {
            if (valor > SALDO_MINIMO_CONTA){
                saldo+=valor;
                System.out.println("Deposito realizado no valor de R$ "+valor);
            }else {
                System.out.println("Valor inválido.");
            }
        }
    }

    public abstract void saque(double valor);

    public Cliente04 getCliente04() {
        return cliente04;
    }

    public void setCliente04(Cliente04 cliente04) {
        this.cliente04 = cliente04;
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

    public Cliente04.TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Cliente04.TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Cliente04.StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(Cliente04.StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Conta: %d |Saldo:R$ %.2f |Status conta: %s",cliente04.getNome(),cliente04.getCpf(),numeroConta,saldo,statusConta);
    }
}
