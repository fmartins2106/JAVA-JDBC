package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente30 extends Conta30{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente30(Cliente30 cliente30, int numeroConta, double saldo, TipoConta30 tipoConta30, StatusConta30 statusConta30) {
        super(cliente30, numeroConta, saldo, tipoConta30, statusConta30);
    }

    @Override
    public void sacar(double valor){
        if (statusConta30 == StatusConta30.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoConta30.SAQUE.getDescricaoFormadatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoConta30.ERRO_VALOR_SAQUE.getDescricaoFormadatada(getSaldo()));
            }
        }else {
            System.out.println(MensagensValidacaoConta30.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }
}
