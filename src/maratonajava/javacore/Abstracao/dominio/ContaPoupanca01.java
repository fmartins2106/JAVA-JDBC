package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca01 extends Conta01{
    public ContaPoupanca01(Cliente01 cliente01, int numeroConta, double saldo, Cliente01.TipoDeConta tipoDeConta, Cliente01.StatusConta statusConta) {
        super(cliente01, numeroConta, saldo, tipoDeConta, statusConta);
    }

    @Override
    public void saca(double valor){
        if (statusConta != Cliente01.StatusConta.ATIVA){
            System.out.println("Operação negada, conta inativa.");
            return;
        }
        if (valor <= saldo){
            saldo -= valor;
            System.out.println("Saque de R$ "+valor+" realizado");
        }else {
            System.out.println("Saldo insuficiente.");
        }

    }
}
