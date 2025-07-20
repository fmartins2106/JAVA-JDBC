package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente20 extends Conta20{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente20(Cliente20 cliente20, int numeroConta, double saldo, Cliente20.TipoConta20 tipoConta20, Cliente20.StatusConta20 statusConta20) {
        super(cliente20, numeroConta, saldo, tipoConta20, statusConta20);
    }

    public void sacar(double valor){
        if (statusConta20 == Cliente20.StatusConta20.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor+TAXA_SAQUE);
                System.out.println(Cliente20.MensagensValidacaoCliente20.SAQUE.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_STATUS_SAQUE.getDescricao());
        }
    }
}
