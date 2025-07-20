package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente04 extends Conta04{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente04(Cliente04 cliente04, int numeroConta, double saldo, Cliente04.TipoConta tipoConta, Cliente04.StatusConta statusConta) {
        super(cliente04, numeroConta, saldo, tipoConta, statusConta);
    }

    @Override
    public void saque(double valor){
        if (statusConta != Cliente04.StatusConta.ATIVA){
            System.out.println(Cliente04.ValidacaoDescricao.ERRO_CONTA_INATIVA);
            return;
        }
        if (valor + TAXA_SAQUE <= saldo){
            saldo -= (valor + TAXA_SAQUE);
            System.out.println("Saque no valor de R$"+valor+" realizado. Taxa de R$"+TAXA_SAQUE+" aplicado.");
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }

}
