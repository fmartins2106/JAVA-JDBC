package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente06 extends Conta06{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente06(Cliente06 cliente06, int numeroConta, double saldo, Cliente06.TipoDaConta tipoDaConta, Cliente06.StatusDaConta statusDaConta) {
        super(cliente06, numeroConta, saldo, tipoDaConta, statusDaConta);
    }

    @Override
    public void saque(double valor){
        if (statusDaConta != Cliente06.StatusDaConta.ATIVA){
            System.out.println(Cliente06.Validation.CONTA_INATIVA.getDescricao());
            return;
        }
        if (valor + TAXA_SAQUE <= saldo){
            saldo -= (valor +TAXA_SAQUE);
            System.out.println("Saque realizado no valor de R$"+valor+". Taxa de R$ "+TAXA_SAQUE+" aplicada.");
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }

}
