package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta09 {
    protected Cliente09 cliente09;
    protected int numeroConta;
    protected double saldo;
    protected Cliente09.TipoContas tipoContas;
    protected Cliente09.StatusContas statusContas;

    public Conta09(Cliente09 cliente09, int numeroConta, double saldo, Cliente09.TipoContas tipoContas, Cliente09.StatusContas statusContas) {
        this.cliente09 = cliente09;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoContas = tipoContas;
        this.statusContas = statusContas;
    }

    public static final int DIGITOS_CONTA = 6;
    public static final double SALDO_MINIMO =0;


    private void validacaoNumerConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_CONTA){
            throw new IllegalArgumentException(Cliente09.ErroMensagens.ERRO_CONTA.getDescricao());
        }
    }

    private void  validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente08.ErrorMessage.SALDO_MINIMO.getDescricao());
        }
    }

    public void bloquear(){
        statusContas = Cliente09.StatusContas.BLOQUEADA;
        System.out.println("Conta bloqueada.");
    }

    public void desbloquearConta(){
        if (statusContas == Cliente09.StatusContas.BLOQUEADA){
            statusContas = Cliente09.StatusContas.ATIVA;
            System.out.println("Conta desbloqueada com sucesso.");
        }else {
            if (statusContas == Cliente09.StatusContas.CANCELADA){
                System.out.println("Desbloqueio não permitido, Conta está bloqueada.");
            }else {
                System.out.println("Operação negada. Conta já esta ativa.");
            }
        }
    }

    public void encerrarConta(){
        if (saldo == SALDO_MINIMO){
            statusContas = Cliente09.StatusContas.CANCELADA;
            System.out.println(Cliente09.ErroMensagens.CONTA_CANCELADA.getDescricao());
        }else {
            System.out.println(Cliente09.ErroMensagens.ERRO_CONTA_CANCELADA.getDescricao());
        }
    }

    public void deposistar(double valor){
        if (statusContas != Cliente09.StatusContas.ATIVA){
            System.out.println(Cliente09.ErroMensagens.ERRO_DEPOSITO.getDescricao());
        }else {
            if ( valor < SALDO_MINIMO){
                System.out.println("Operação negada, deposito não pode ser menor que zero.");
            }else {
                saldo+= valor;
                System.out.println("Deposito no valor de R$"+valor+" realizado com sucesso.");
            }
        }
    }

    public abstract void saque(double valor);

    public Cliente09 getCliente09() {
        return cliente09;
    }

    public void setCliente09(Cliente09 cliente09) {
        this.cliente09 = cliente09;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumerConta(numeroConta);
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente09.TipoContas getTipoContas() {
        return tipoContas;
    }

    public void setTipoContas(Cliente09.TipoContas tipoContas) {
        this.tipoContas = tipoContas;
    }

    public Cliente09.StatusContas getStatusContas() {
        return statusContas;
    }

    public void setStatusContas(Cliente09.StatusContas statusContas) {
        this.statusContas = statusContas;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente09.getNome(),cliente09.getCpf(),numeroConta,saldo,tipoContas,statusContas);
    }

}
