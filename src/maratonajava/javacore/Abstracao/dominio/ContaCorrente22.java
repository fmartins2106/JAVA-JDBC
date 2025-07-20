package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente22 extends Conta22{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente22(Cliente22 cliente22, int numeroConta, double saldo, Cliente22.TipoConta22 tipoConta22, Cliente22.StatusConta22 statusConta22) {
        super(cliente22, numeroConta, saldo, tipoConta22, statusConta22);
    }

    @Override
    public void sacar(double valor){
        if (statusConta22 == Cliente22.StatusConta22.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(Cliente22.MensagensValidacaoCliente22.SAQUE_EFETUADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(Cliente22.MensagensValidacaoCliente22.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente22.MensagensValidacaoCliente22.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }
}
