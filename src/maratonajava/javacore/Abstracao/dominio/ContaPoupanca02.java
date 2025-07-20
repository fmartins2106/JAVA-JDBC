package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca02 extends Conta02 {
    public ContaPoupanca02(Cliente02 cliente02, int numeroConta, double saldo, Cliente02.TipoConta tipoConta, Cliente02.StatusConta statusConta) {
        super(cliente02, numeroConta, saldo, tipoConta, statusConta);
    }

    @Override
    public void sacar(double valor){
        if (statusConta != Cliente02.StatusConta.ATIVA){
            System.out.println("Operação negada, conta inativa.");
            return;
        }
        if (valor <= saldo){
            saldo -= valor;
            System.out.println("Saque de R$"+valor+" realizado.");
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
