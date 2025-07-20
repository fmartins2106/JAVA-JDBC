package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca03 extends Conta03{
    public ContaPoupanca03(Cliente03 cliente03, int numeroConta, double saldo, Cliente03.TipoConta tipoConta, Cliente03.StatusConta statusConta) {
        super(cliente03, numeroConta, saldo, tipoConta, statusConta);
    }

    @Override
    public void saque(double valor){
        if (statusConta != Cliente03.StatusConta.ATIVA){
            System.out.println("Conta inativa, não é possivel fazer saque.");
            return;
        }
        if ( valor <= saldo){
            saldo -= valor;
            System.out.println("Saque efetuado no valor de R$"+valor);
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
