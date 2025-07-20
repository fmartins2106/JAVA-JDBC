package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente21 extends Conta21{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente21(Cliente21 cliente21, int numeroConta, double saldo, Cliente21.TipoConta21 tipoConta21, Cliente21.StatusConta21 statusConta21) {
        super(cliente21, numeroConta, saldo, tipoConta21, statusConta21);
    }

    @Override
    public void sacar(double valor){
        if (statusConta21 == Cliente21.StatusConta21.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(Cliente21.MensagensValidacaoCliente21.SAQUE_REALIZADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_STATUS_CONTA_CANCELADA.getDescricao());
        }
    }

}
