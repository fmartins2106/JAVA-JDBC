package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta02 {
    protected Cliente02 cliente02;
    protected int numeroConta;
    protected double saldo;
    protected Cliente02.TipoConta tipoConta;
    protected Cliente02.StatusConta statusConta;

    public Conta02(Cliente02 cliente02, int numeroConta, double saldo, Cliente02.TipoConta tipoConta, Cliente02.StatusConta statusConta) {
        this.cliente02 = cliente02;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.statusConta = statusConta;
    }

    public static final int NUMERO_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void  validacaoNumeroConta(int numeroConta){
        if (numeroConta < NUMERO_CONTA){
            throw new IllegalArgumentException(Cliente02.MensagemValidacao.ERRO_NUMERO_CONTA.getDescricao());
        }
        String numeroStr = String.valueOf(numeroConta);
        if (numeroStr.length() != 6){
            System.out.println(Cliente02.MensagemValidacao.ERRO_NUMERO_CONTA);
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente02.MensagemValidacao.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        this.statusConta = Cliente02.StatusConta.BLOQUEADA;
        System.out.println(Cliente02.MensagemValidacao.ERRO_CONTA_BLOQUEADA);
    }

    public void desbloquearConta(){
        if (this.statusConta == Cliente02.StatusConta.BLOQUEADA){
            this.statusConta = Cliente02.StatusConta.ATIVA;
            System.out.println("Conta desbloqueada com sucesso.");
        }else {
            System.out.println("A conta não está bloqueada.");
        }
    }

    public void encerrarConta(){
        if (saldo <= 0){
            this.statusConta = Cliente02.StatusConta.CANCELADA;
            System.out.println(Cliente02.MensagemValidacao.ERRO_ENCERRAR_CONTA);
        }else {
            System.out.println("Conta precisa ter saldo zerado para ser cancelada.");
        }
    }

    public void depositar(double valor){
        if (statusConta != Cliente02.StatusConta.ATIVA){
            System.out.println(Cliente02.MensagemValidacao.ERRO_CONTA_INATIVA.getDescricao());
        }else {
            if (valor > SALDO_MINIMO) {
                saldo += valor;
                System.out.println("Deposito de R$ " + valor + " realizado com sucesso.");
            } else {
                System.out.println("Valor inválido.");
            }
        }
    }

    public void validacaoSaque(double valor){
        if (statusConta != Cliente02.StatusConta.ATIVA){
            System.out.println(Cliente02.MensagemValidacao.ERRO_NUMERO_CONTA.getDescricao());
        }else {
            if (valor > SALDO_MINIMO){
                saldo-= valor;
                System.out.println("Saque realizado no valor de R$"+valor);
            }else {
                System.out.println("Valor inválido.");
            }
        }
    }

    public void sacar(double valor){
        validacaoSaque(valor);
    }

    public Cliente02 getCliente02() {
        return cliente02;
    }

    public void setCliente02(Cliente02 cliente02) {
        this.cliente02 = cliente02;
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

    public Cliente02.TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Cliente02.TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Cliente02.StatusConta getStatusConta() {
        return statusConta;
    }
    public void setStatusConta(Cliente02.StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |CPF: %s |Conta: %s |Número da conta: %d |Saldo: %.2f |Status: %s", cliente02.getNome(),cliente02.getCpf(),tipoConta,numeroConta,saldo,statusConta);
    }

}
