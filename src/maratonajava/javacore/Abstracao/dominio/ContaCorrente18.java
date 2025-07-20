package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente18 extends Conta18{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente18(Cliente18 cliente18, int numeroConta, double saldo, Cliente18.TipoConta18 tipoConta18, Cliente18.StatusConta18 statusConta18) {
        super(cliente18, numeroConta, saldo, tipoConta18, statusConta18);
    }

    @Override
    public void sacar(double valor){
        if (statusConta18 == Cliente18.StatusConta18.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor+ TAXA_SAQUE);
                System.out.println(Cliente18.MensagensValidacaoCliente18.SAQUE_REALIZADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(Cliente18.MensagensValidacaoCliente18.ERRO_SAQUE_VALOR.getDescricao());
            }
        }else {
            System.out.println(Cliente18.MensagensValidacaoCliente18.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }

}
