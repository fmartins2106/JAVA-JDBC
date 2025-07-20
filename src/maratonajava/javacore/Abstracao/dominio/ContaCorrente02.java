package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente02 extends Conta02 {
    private static final double TAXA_SAQUE =5.0;

    public ContaCorrente02(Cliente02 cliente02, int numeroConta, double saldo, Cliente02.TipoConta tipoConta, Cliente02.StatusConta statusConta) {
        super(cliente02, numeroConta, saldo, tipoConta, statusConta);
    }

    @Override
    public void sacar(double valor){
        if (statusConta != Cliente02.StatusConta.ATIVA){
            System.out.println("Operação negada a conta não está ativa.");
            return;
        }
        if (valor + TAXA_SAQUE <= saldo){
            saldo -= (valor+ TAXA_SAQUE);
            System.out.println("Saque no valor de R$"+valor+" realizado. Taxa de R$"+TAXA_SAQUE+" aplicado.");
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }

}
