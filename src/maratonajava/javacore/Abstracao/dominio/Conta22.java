package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta22 {
    protected Cliente22 cliente22;
    protected int numeroConta;
    protected double saldo;
    protected Cliente22.TipoConta22 tipoConta22;
    protected Cliente22.StatusConta22 statusConta22;

    public Conta22(Cliente22 cliente22, int numeroConta, double saldo, Cliente22.TipoConta22 tipoConta22, Cliente22.StatusConta22 statusConta22) {
        this.cliente22 = cliente22;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoConta22 = tipoConta22;
        this.statusConta22 = statusConta22;
    }

    public static final double SALDO_MINIMO = 0;
    public static final int DIGITOS_PADRAO_CONTA = 6;

//    private static Set<Integer> cadastroNumeroConta = new HashSet<>();

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_PADRAO_CONTA){
            throw new IllegalArgumentException(Cliente22.MensagensValidacaoCliente22.ERRO_NUMERO_CONTA.getDescricaoFormatada(DIGITOS_PADRAO_CONTA));
        }
//        if (cadastroNumeroConta.contains(numeroConta)){
//            throw new IllegalArgumentException(Cliente22.MensagensValidacaoCliente22.CONTA_DUPLIACADA.getDescricao());
//        }
    }

    public static void validacaoSaldo(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente22.MensagensValidacaoCliente22.ERRO_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void bloquearConta(){
        if (statusConta22 == Cliente22.StatusConta22.ATIVA){
            statusConta22 = Cliente22.StatusConta22.BLOQUEADA;
            System.out.println(Cliente22.MensagensValidacaoCliente22.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente22.MensagensValidacaoCliente22.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }

    public void desbloquearConta(){
        if (statusConta22 == Cliente22.StatusConta22.BLOQUEADA){
            statusConta22 = Cliente22.StatusConta22.ATIVA;
            System.out.println(Cliente22.MensagensValidacaoCliente22.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente22.MensagensValidacaoCliente22.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void cancelarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusConta22 == Cliente22.StatusConta22.ATIVA){
                statusConta22 = Cliente22.StatusConta22.CANCELADA;
                System.out.println(Cliente22.MensagensValidacaoCliente22.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente22.MensagensValidacaoCliente22.ERRO_CONTA_CANCELADA_STATUS.getDescricao());
            }
        }else {
            System.out.println(Cliente22.MensagensValidacaoCliente22.ERRO_CONTA_CANCELADA_SALDO.getDescricaoFormatada(SALDO_MINIMO));
        }
    }

    public void depositar(double valor) {
        if (statusConta22 == Cliente22.StatusConta22.ATIVA) {
            if (valor > SALDO_MINIMO) {
                saldo += valor;
                System.out.println(Cliente22.MensagensValidacaoCliente22.DEPOSITO_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente22.MensagensValidacaoCliente22.VALOR_DEPOSITO_INVALIDO.getDescricaoFormatada(SALDO_MINIMO));
            }
        }else {
            System.out.println(Cliente22.MensagensValidacaoCliente22.STATUS_DEPOSITO_INVALIDO.getDescricao());
        }
    }

    public abstract void sacar(double valor);

    public Cliente22 getCliente22() {
        return cliente22;
    }

    public void setCliente22(Cliente22 cliente22) {
        this.cliente22 = cliente22;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        validacaoNumeroConta(numeroConta);
        this.numeroConta = numeroConta;
//        cadastroNumeroConta.add(numeroConta);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validacaoSaldo(saldo);
        this.saldo = saldo;
    }

    public Cliente22.TipoConta22 getTipoConta22() {
        return tipoConta22;
    }

    public Cliente22.StatusConta22 getStatusConta22() {
        return statusConta22;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente22.getNome(),cliente22.getCpf(),numeroConta,saldo,tipoConta22,statusConta22);
    }
}
