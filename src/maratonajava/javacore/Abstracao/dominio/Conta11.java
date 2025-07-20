package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta11 {
    protected Cliente11 cliente11;
    protected int numeroConta;
    protected double saldo;
    protected Cliente11.TipoConta11 tipoConta11;
    protected Cliente11.StatusConta11 statusConta11;

    public Conta11(Cliente11 cliente11, int numeroConta, double saldo, Cliente11.TipoConta11 tipoConta11, Cliente11.StatusConta11 statusConta11) {
        this.cliente11 = cliente11;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta11 = tipoConta11;
        this.statusConta11 = statusConta11;
    }

    public static final int DIGITOS_NUMEROS_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMEROS_CONTA){
            throw new IllegalArgumentException(Cliente11.MensagensValidacao11.ERRO_SALDO.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente11.MensagensValidacao11.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        statusConta11 = Cliente11.StatusConta11.BLOQUEADA;
        System.out.println(Cliente11.MensagensValidacao11.CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusConta11 == Cliente11.StatusConta11.BLOQUEADA){
            statusConta11 = Cliente11.StatusConta11.ATIVA;
            System.out.println(Cliente11.MensagensValidacao11.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            if (statusConta11 == Cliente11.StatusConta11.ATIVA){
                System.out.println(Cliente11.MensagensValidacao11.ERRO_DESBLOQUEAR_CONTA.getDescricao());
            }else{
                System.out.println(Cliente11.MensagensValidacao11.ERRO_DESBLOQUEAR_CONTA.getDescricao());
            }
        }
    }

    public void encerrarConta(){
        if (saldo == SALDO_MINIMO){
            statusConta11 = Cliente11.StatusConta11.CALCELADA;
            System.out.println(Cliente11.MensagensValidacao11.CONTA_CANCELADA.getDescricao());
        }else{
            System.out.println(Cliente11.MensagensValidacao11.ERRO_CANCELAMENTO_CONTA.getDescricao());
        }
    }

    public void deposito(double valor){
        if (statusConta11 == Cliente11.StatusConta11.ATIVA){
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println("Deposito de R$"+valor+" realizado com sucesso.");
            }else {
                System.out.println("Valor de depósito inválido.");
            }
        }else {
            System.out.println(Cliente11.MensagensValidacao11.ERRO_DEPOSITO.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente11 getCliente11() {
        return cliente11;
    }

    public void setCliente11(Cliente11 cliente11) {
        this.cliente11 = cliente11;
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

    public Cliente11.TipoConta11 getTipoConta11() {
        return tipoConta11;
    }

    public void setTipoConta11(Cliente11.TipoConta11 tipoConta11) {
        this.tipoConta11 = tipoConta11;
    }

    public Cliente11.StatusConta11 getStatusConta11() {
        return statusConta11;
    }

    public void setStatusConta11(Cliente11.StatusConta11 statusConta11) {
        this.statusConta11 = statusConta11;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo: %.2f |Tipo da conta: %s |Status da conta: %s",
                cliente11.getNome(),cliente11.getCpf(), numeroConta,saldo,tipoConta11,statusConta11);
    }
}
