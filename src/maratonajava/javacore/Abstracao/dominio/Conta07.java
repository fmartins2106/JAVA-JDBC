package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta07 {
    protected Cliente07 cliente07;
    protected int numeroConta;
    protected double saldo;
    protected Cliente07.TipoContas tipoContas;
    protected Cliente07.StatusContas statusContas;

    public Conta07(Cliente07 cliente07, int numeroConta, double saldo, Cliente07.TipoContas tipoContas, Cliente07.StatusContas statusContas) {
        this.cliente07 = cliente07;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoContas = tipoContas;
        this.statusContas = statusContas;
    }

    public static final int DIGITOS_MINIMO_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    private void validacaoNumeroConta(int numeroConta){
        if (numeroConta < DIGITOS_MINIMO_CONTA){
            throw new IllegalArgumentException(Cliente07.ValidationDescription.MENSAGEM_ERR0_CONTA.getDescricao());
        }
    }

    private void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente07.ValidationDescription.MENSAGEM_ERRO_SALDO.getDescricao());
        }
    }

    public void bloquear(){
        statusContas = Cliente07.StatusContas.BLOQUEADA;
        System.out.println(Cliente07.ValidationDescription.MENSAGEM_ERRO_CONTA_BLOQUEADA.getDescricao());
    }

    public void desbloquearConta(){
        if (statusContas == Cliente07.StatusContas.BLOQUEADA){
            statusContas = Cliente07.StatusContas.ATIVA;
            System.out.println("Conta desbloqueada com sucesso.");
        }else {
            if (statusContas == Cliente07.StatusContas.ATIVA){
                System.out.println("Operação negada, conta não está bloqueada. verifique !");
            }else {
                System.out.println("Operação negada, conta cancelada.");
            }
        }
    }

    public void encerrarConta(){
        if (saldo <= SALDO_MINIMO){
            statusContas = Cliente07.StatusContas.CANCELADA;
            System.out.println(Cliente07.ValidationDescription.MENSAGEM_CONTA_CANCELADA.getDescricao());
        }else {
            System.out.println(Cliente07.ValidationDescription.MENSAGEM_ERRO_ERRO_CANCELAMENTO.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusContas != Cliente07.StatusContas.ATIVA){
            System.out.println(Cliente07.ValidationDescription.ERR0_CONTA_INATIVA.getDescricao());
        }else {
            if (valor  > SALDO_MINIMO){
                saldo+=valor;
                System.out.println("Deposito de R$"+valor+" realizado com sucesso.");
            }else {
                System.out.println("Valor inválido.");
            }
        }
    }

    public abstract void saque(double valor);

    public Cliente07 getCliente07() {
        return cliente07;
    }

    public void setCliente07(Cliente07 cliente07) {
        this.cliente07 = cliente07;
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

    public Cliente07.TipoContas getTipoContas() {
        return tipoContas;
    }

    public void setTipoContas(Cliente07.TipoContas tipoContas) {
        this.tipoContas = tipoContas;
    }

    public Cliente07.StatusContas getStatusContas() {
        return statusContas;
    }

    public void setStatusContas(Cliente07.StatusContas statusContas) {
        this.statusContas = statusContas;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo %.2f |Tipo conta: %s |Status conta: %s",
                cliente07.getNome(), cliente07.getCpf(),numeroConta,saldo,tipoContas,statusContas);
    }
}
