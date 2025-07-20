package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente01 extends Conta01{
    private static final double TAXA_SAQUE = 5.0;

    public ContaCorrente01(Cliente01 cliente01, int numeroConta, double saldo, Cliente01.TipoDeConta tipoDeConta, Cliente01.StatusConta statusConta) {
        super(cliente01, numeroConta, saldo, tipoDeConta, statusConta);
    }

    @Override
    public  void saca(double valor){
        if (statusConta != Cliente01.StatusConta.ATIVA){
            System.out.println("Operação negada, a conta não está ativa.");
            return;
        }
        if (valor + TAXA_SAQUE <= saldo){
            saldo -= (valor +TAXA_SAQUE);
            System.out.println("Saque de R$"+valor+" realizado. Taxa de R$"+TAXA_SAQUE+" aplicado.");
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }

}
