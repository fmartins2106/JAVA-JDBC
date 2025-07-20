package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public abstract class Conta16 {
    protected Cliente16 cliente16;
    protected int numeroConta;
    protected double saldo;
    protected Cliente16.TipoContaCliente16 tipoContaCliente16;
    protected Cliente16.StatusContaCliente16 statusContaCliente16;

    public Conta16(Cliente16 cliente16, int numeroConta, double saldo, Cliente16.TipoContaCliente16 tipoContaCliente16, Cliente16.StatusContaCliente16 statusContaCliente16) {
        this.cliente16 = cliente16;
        setNumeroConta(numeroConta);
        setSaldo(saldo);
        this.tipoContaCliente16 = tipoContaCliente16;
        this.statusContaCliente16 = statusContaCliente16;
    }

    public static final int DIGITOS_NUMEROS_CONTA = 6;
    public static final double SALDO_MINIMO = 0;

    public static void validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != DIGITOS_NUMEROS_CONTA){
            throw new IllegalArgumentException(Cliente16.MensagensValidacaoCliente16.ERRO_DIGITOS_CONTA.getDescricao());
        }
    }

    public static void validacaoSaldoConta(double saldo){
        if (saldo < SALDO_MINIMO){
            throw new IllegalArgumentException(Cliente16.MensagensValidacaoCliente16.ERRO_SALDO.getDescricao());
        }
    }

    public void bloquearConta(){
        if (statusContaCliente16 == Cliente16.StatusContaCliente16.ATIVO){
            statusContaCliente16 = Cliente16.StatusContaCliente16.BLOQUEADA;
            System.out.println(Cliente16.MensagensValidacaoCliente16.CONTA_BLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_CONTA_BLOQUEADA.getDescricao());
        }
    }


    public void desbloquearConta(){
        if (statusContaCliente16 == Cliente16.StatusContaCliente16.BLOQUEADA){
            statusContaCliente16 = Cliente16.StatusContaCliente16.ATIVO;
            System.out.println(Cliente16.MensagensValidacaoCliente16.CONTA_DESBLOQUEADA.getDescricao());
        }else {
            System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_CONTA_DESBLOQUEADA.getDescricao());
        }
    }

    public void depositar(double valor){
        if (statusContaCliente16 == Cliente16.StatusContaCliente16.ATIVO){
            if (valor > SALDO_MINIMO){
                saldo+=valor;
                System.out.println(Cliente16.MensagensValidacaoCliente16.DEPOSITO_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_VALOR_DEPOSITO.getDescricao());
            }
        }else {
            System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_DEPOSITO_STATUS.getDescricao());
        }
    }

    public void encerrarConta(){
        if (saldo == SALDO_MINIMO){
            if (statusContaCliente16 == Cliente16.StatusContaCliente16.ATIVO){
                statusContaCliente16 = Cliente16.StatusContaCliente16.CANCELADA;
                System.out.println(Cliente16.MensagensValidacaoCliente16.CONTA_CANCELADA.getDescricao());
            }else {
                System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_CONTA_CANCELADA.getDescricao());
            }
        }else {
            System.out.println(Cliente16.MensagensValidacaoCliente16.ERR0_CONTA_CANCELADA2.getDescricao());
        }
    }

    public abstract void  sacar(double valor);

    public Cliente16 getClieten16() {
        return cliente16;
    }

    public void setClieten16(Cliente16 cliente16) {
        this.cliente16 = cliente16;
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

    public Cliente16.TipoContaCliente16 getTipoContaCliente16() {
        return tipoContaCliente16;
    }

    public void setTipoContaCliente16(Cliente16.TipoContaCliente16 tipoContaCliente16) {
        this.tipoContaCliente16 = tipoContaCliente16;
    }

    public Cliente16.StatusContaCliente16 getStatusContaCliente16() {
        return statusContaCliente16;
    }

    public void setStatusContaCliente16(Cliente16.StatusContaCliente16 statusContaCliente16) {
        this.statusContaCliente16 = statusContaCliente16;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Número da conta: %d |Saldo: %.2f |Tipo conta: %s |Status conta: %s",
                cliente16.getNome(), cliente16.getCpf(), numeroConta,saldo,tipoContaCliente16,statusContaCliente16);
    }

}
