package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta08 {
    protected Cliente08 cliente08;
    protected int numeroConta;
    protected double saldo;
    protected Cliente08.TipoContaBanco tipoContaBanco;
    protected Cliente08.StatusContaBanco statusContaBanco;

    public Conta08(Cliente08 cliente08, int numeroConta, double saldo, Cliente08.TipoContaBanco tipoContaBanco, Cliente08.StatusContaBanco statusContaBanco) {
        this.cliente08 = cliente08;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoContaBanco = tipoContaBanco;
        this.statusContaBanco = statusContaBanco;
    }

    public static final int DIGITOS_MINIMO_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        if (numeroConta < DIGITOS_MINIMO_CONTA){
            throw new IllegalArgumentException(Cliente08.ErrorMessage.DIGITOS_MINIMO_CONTA.getDescricao());
        }
    }

    private void  validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente08.ErrorMessage.SALDO_MINIMO.getDescricao());
        }
    }

    public void bloquear(){
        statusContaBanco = Cliente08.StatusContaBanco.BLOQUEADA;
        System.out.println("Conta bloqueada com sucesso.");
    }

    public void desbloquearConta(){
        if (statusContaBanco == Cliente08.StatusContaBanco.BLOQUEADA){
            statusContaBanco = Cliente08.StatusContaBanco.ATIVA;
        }else {
            if (statusContaBanco == Cliente08.StatusContaBanco.CANCELADA){
                System.out.println("Sua conta já está cancelada.");
            }else {
                System.out.println("Sua conta já está ativa. Verifique.");
            }
        }
    }

    public void encerrarConta(){
        if (saldo == SALDO_MINIMO){
            statusContaBanco = Cliente08.StatusContaBanco.CANCELADA;
            System.out.println(Cliente08.ErrorMessage.CONTA_CANCELADA.getDescricao());
        }else {
            System.out.println(Cliente08.ErrorMessage.ERRO_CANCELAMENTO.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusContaBanco != Cliente08.StatusContaBanco.ATIVA){
            System.out.println(Cliente08.ErrorMessage.CONTA_INATIVA.getDescricao());
        }else {
            if (valor < SALDO_MINIMO){
                System.out.println("Operação inválida. Valor precisa ser maior que zero.");
            }else {
                saldo +=valor;
                System.out.println("Deposito de R$"+valor+" relizado com sucesso.");
            }
        }
    }

    public abstract void saque(double valor);

    public Cliente08 getCliente08() {
        return cliente08;
    }

    public void setCliente08(Cliente08 cliente08) {
        this.cliente08 = cliente08;
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

    public Cliente08.TipoContaBanco getTipoContaBanco() {
        return tipoContaBanco;
    }

    public void setTipoContaBanco(Cliente08.TipoContaBanco tipoContaBanco) {
        this.tipoContaBanco = tipoContaBanco;
    }

    public Cliente08.StatusContaBanco getStatusContaBanco() {
        return statusContaBanco;
    }

    public void setStatusContaBanco(Cliente08.StatusContaBanco statusContaBanco) {
        this.statusContaBanco = statusContaBanco;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo:R$ %.2f |Tipo conta: %s |Status conta: %s",
                cliente08.getNome(),cliente08.getCpf(),numeroConta,saldo,tipoContaBanco,statusContaBanco);
    }

}
