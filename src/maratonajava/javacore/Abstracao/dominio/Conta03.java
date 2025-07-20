package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta03 {
    protected Cliente03 cliente03;
    protected int numeroConta;
    protected double saldo;
    protected Cliente03.TipoConta tipoConta;
    protected Cliente03.StatusConta statusConta;

    public Conta03(Cliente03 cliente03, int numeroConta, double saldo, Cliente03.TipoConta tipoConta, Cliente03.StatusConta statusConta) {
        this.cliente03 = cliente03;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta = tipoConta;
        this.statusConta = statusConta;
    }

    public static final int DIGITOS_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        String numerContaSrt = String.valueOf(numeroConta);
        if (numerContaSrt.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(Cliente03.MensagensErro.ERRO_CONTA.getDescricao());
        }
    }

    private void validacaoSaldo(double salado){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente03.MensagensErro.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        this.statusConta = Cliente03.StatusConta.BLOQUEADA;
        System.out.println(Cliente03.MensagensErro.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (this.statusConta == Cliente03.StatusConta.BLOQUEADA){
            this.statusConta = Cliente03.StatusConta.ATIVA;
            System.out.println("Conta desbloqueada com sucesso.");
        }else {
            System.out.println("A conta não está bloqueada.");
        }
    }

    public void encerrarConta(){
        if (saldo <= 0){
            this.statusConta = Cliente03.StatusConta.CANCELADA;
            System.out.println(Cliente03.MensagensErro.ERRO_CONTA_ENCERRADA.getDescricao());
        }else {
            System.out.println("Conta precisa ter saldo zerado para ser cancelada.");
        }
    }

    public void depositar(double valor){
        if (statusConta != Cliente03.StatusConta.ATIVA){
            System.out.println(Cliente03.MensagensErro.ERRO_CONTA_INATIVA.getDescricao());
        }else {
            if (valor > SALDO_MINIMO){
                saldo+= valor;
                System.out.println("Deposito de R$"+valor+" realizado com sucesso.");
            }else {
                System.out.println("Valor inválido.");
            }
        }
    }

    public abstract void saque(double valor);

    public Cliente03 getCliente03() {
        return cliente03;
    }

    public void setCliente03(Cliente03 cliente03) {
        this.cliente03 = cliente03;
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

    public Cliente03.TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(Cliente03.TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Cliente03.StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(Cliente03.StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Conta:%d |Saldo: %.2f |Status: %s",cliente03.getNome(),cliente03.getCpf(),numeroConta,saldo,statusConta);
    }
}
