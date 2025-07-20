package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente17 extends Conta17{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente17(Cliente17 cliente17, int numeroConta, double saldo, Cliente17.TipoConta17 tipoConta17, Cliente17.StatusConta17 statusConta17) {
        super(cliente17, numeroConta, saldo, tipoConta17, statusConta17);
    }

    @Override
    public void sacar(double valor){
        if (statusConta17 == Cliente17.StatusConta17.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo-=(valor +TAXA_SAQUE);
                System.out.println(Cliente17.MensagemValidacaoCliente17.SAQUE_CORRENTE.getDescricaoFortatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_SALDO_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_CONTA_SAQUE.getDescricao());
        }
    }

}
