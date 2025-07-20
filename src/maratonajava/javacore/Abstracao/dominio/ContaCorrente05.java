package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente05 extends Conta05{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente05(Cliente05 cliente05, int numeroConta, double saldo, Cliente05.Status status, Cliente05.Tipo tipo) {
        super(cliente05, numeroConta, saldo, status, tipo);
    }

    @Override
    public void saque(double valor){
        if (status != Cliente05.Status.ATIVA){
            System.out.println(Cliente05.Mensagens.ERR0_CONTA_INATIVA.getDescricao());
            return;
        }
        if (valor + TAXA_SAQUE <= saldo){
            saldo -= (valor + TAXA_SAQUE);
            System.out.println("Saque no valor de R$"+valor+" realizado. Taxa de R$ "+TAXA_SAQUE+" aplicado.");
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
