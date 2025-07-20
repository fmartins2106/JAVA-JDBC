package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca05 extends Conta05{
    public ContaPoupanca05(Cliente05 cliente05, int numeroConta, double saldo, Cliente05.Status status, Cliente05.Tipo tipo) {
        super(cliente05, numeroConta, saldo, status, tipo);
    }

    @Override
    public void saque(double valor){
        if (status != Cliente05.Status.ATIVA){
            System.out.println(Cliente05.Mensagens.ERR0_CONTA_INATIVA);
            return;
        }
        if (valor <= SALDO_MINIMO){
            saldo -= valor;
            System.out.println("Saque realizado no valor de R$"+valor);
        }else {
            System.out.println("Valor inválido.");
        }
    }
}
