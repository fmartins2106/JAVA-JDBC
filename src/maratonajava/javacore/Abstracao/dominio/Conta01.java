package academy.devdojo.maratonajava.javacore.Abstracao.dominio;


public abstract class Conta01 {
    protected Cliente01 cliente01;
    protected int numeroConta;
    protected double saldo;
    protected Cliente01.TipoDeConta tipoDeConta;
    protected Cliente01.StatusConta statusConta;

    public Conta01(Cliente01 cliente01, int numeroConta, double saldo, Cliente01.TipoDeConta tipoDeConta, Cliente01.StatusConta statusConta) {
        this.cliente01 = cliente01;
        setNumeroConta(numeroConta);
        this.saldo = saldo;
        this.tipoDeConta = tipoDeConta;
        this.statusConta = statusConta;
    }

    public static final int NUMERO_CONTA = 1;
    public static final int SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        if (numeroConta < NUMERO_CONTA){
            throw new IllegalArgumentException(Cliente01.MensagemValidacao.ERRO_NUMERO_CONTA.getDescricao());
        }
        String numeroStr = String.valueOf(numeroConta);
        if (numeroStr.length() < 6){
            throw new IllegalArgumentException(Cliente01.MensagemValidacao.ERRO_NUMERO_CONTA.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente01.MensagemValidacao.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        this.statusConta = Cliente01.StatusConta.BLOQUEADA;
        System.out.println(Cliente01.MensagemValidacao.ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void  desbloquearConta(){
        if (this.statusConta == Cliente01.StatusConta.BLOQUEADA){
            this.statusConta = Cliente01.StatusConta.ATIVA;
            System.out.println("Conta desbloqueada com sucesso.");
        }else {
            System.out.println("A conta não está bloqueada.");
        }
    }


    public void encerrarConta(){
        if (saldo == 0){
            this.statusConta = Cliente01.StatusConta.CANCELADA;
            System.out.println(Cliente01.MensagemValidacao.ERRO_ENCERRAR_CONTA.getDescricao());
        }else {
            System.out.println("Conta precisa ter saldo zerado para fechar a conta.");
        }
    }

    public void depositar(double valor){
        if (statusConta != Cliente01.StatusConta.ATIVA){
            System.out.println(Cliente01.MensagemValidacao.ERRO_CONTA_INATIVA.getDescricao());
        }else {
            if (valor > SALDO_MINIMO){
                saldo+= valor;
                System.out.println("Depósito de R$ "+valor+" realizado com sucesso.");
            }else {
                System.out.println("Valor inválido.");
            }
        }
    }

    public abstract void saca(double valor);


    public Cliente01 getCliente01() {
        return cliente01;
    }

    public void setCliente01(Cliente01 cliente01) {
        this.cliente01 = cliente01;
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

    public Cliente01.TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(Cliente01.TipoDeConta tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public Cliente01.StatusConta getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(Cliente01.StatusConta statusConta) {
        this.statusConta = statusConta;
    }

    @Override
    public String toString(){
        return String.format("Conta: "+tipoDeConta+" |Número: "+numeroConta+ " |Cliente: "+cliente01.getNome()+" |Saldo: "+saldo+" |Status: "+statusConta);
    }
}
