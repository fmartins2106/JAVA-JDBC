package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta05 {
    protected Cliente05 cliente05;
    protected int numeroConta;
    protected double saldo;
    protected Cliente05.Status status;
    protected Cliente05.Tipo tipo;

    public Conta05(Cliente05 cliente05, int numeroConta, double saldo, Cliente05.Status status, Cliente05.Tipo tipo) {
        this.cliente05 = cliente05;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.status = status;
        this.tipo = tipo;
    }

    public static final int TOTAL_DIGITOS_CONTAS = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != TOTAL_DIGITOS_CONTAS){
            throw new IllegalArgumentException(Cliente05.Mensagens.ERRO_CONTA_DIGITOS.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente05.Mensagens.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        this.status  = Cliente05.Status.BLOQUEADA;
        System.out.println(Cliente05.Mensagens.CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (this.status == Cliente05.Status.BLOQUEADA){
            this.status = Cliente05.Status.ATIVA;
            System.out.println("Conta desbloqueada com sucesso.");
        }else {
            System.out.println("Conta não está bloqueada. operação inválida.");
        }
    }

    public void encerrarConta(){
        if (saldo <= SALDO_MINIMO){
            this.status = Cliente05.Status.CANCELADA;
            System.out.println(Cliente05.Mensagens.CONTA_ENCERRADA.getDescricao());
        }else {
            System.out.println(Cliente05.Mensagens.ERRO_CANCELAR_CONTA.getDescricao());
        }
    }

    public void depositar(double valor){
        if (this.status != Cliente05.Status.ATIVA){
            System.out.println(Cliente05.Mensagens.ERR0_CONTA_INATIVA.getDescricao());
        }else {
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println("Deposito realizado no valor de R$"+valor);
            }else {
                System.out.println("Valor inválido.");
            }
        }
    }

    public abstract void saque(double valor);

    public Cliente05 getCliente05() {
        return cliente05;
    }

    public void setCliente05(Cliente05 cliente05) {
        this.cliente05 = cliente05;
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

    public Cliente05.Status getStatus() {
        return status;
    }

    public void setStatus(Cliente05.Status status) {
        this.status = status;
    }

    public Cliente05.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Cliente05.Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Conta: %d |Saldo:R$ %.2f |Status Conta: %s",cliente05.getNome(),cliente05.getCpf(),
                numeroConta,saldo, status);
    }
}
