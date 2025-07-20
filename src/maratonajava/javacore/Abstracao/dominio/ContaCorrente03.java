package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente03 extends Conta03 {
    private static final double TAXA_SAQUE =5;

    public ContaCorrente03(Cliente03 cliente03, int numeroConta, double saldo, Cliente03.TipoConta tipoConta, Cliente03.StatusConta statusConta) {
        super(cliente03, numeroConta, saldo, tipoConta, statusConta);
    }

    @Override
    public void saque(double valor){
        if (statusConta != Cliente03.StatusConta.ATIVA){
            System.out.println("Operação negadata, conta não está atiava.");
            return;
        }
        if (valor + TAXA_SAQUE <= saldo){
            saldo -=(valor + TAXA_SAQUE);
            System.out.println("Saque  no valor de R$"+valor+" realizado. Taxa de R$"+TAXA_SAQUE+" aplicado.");
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
