package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente23 extends Conta23{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente23(Cliente23 cliente23, int numeroConta, double saldo, Cliente23.TipoConta23 tipoConta23, Cliente23.StatusConta23 statusConta23) {
        super(cliente23, numeroConta, saldo, tipoConta23, statusConta23);
    }

    @Override
    public void sacar(double valor){
        if (statusConta23 == Cliente23.StatusConta23.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor+TAXA_SAQUE);
                System.out.println(Cliente23.MensagensValidacaoCliente23.SAQUE_REALIZADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_SAQUE_VALOR_SALDO.getDescricaoFormatada());
            }
        }else {
            System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }

}
