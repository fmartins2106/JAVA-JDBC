package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente19 extends Conta19{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente19(Cliente19 cliente19, int numeroConta, double saldo, Cliente19.TipoConta19 tipoConta19, Cliente19.StatusConta19 statusConta19) {
        super(cliente19, numeroConta, saldo, tipoConta19, statusConta19);
    }

    @Override
    public void sacar(double valor){
        if (statusConta19 == Cliente19.StatusConta19.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor +TAXA_SAQUE);
                System.out.println(Cliente19.MensagensValidacaoCliente19.SAQUE_CC_REALIZADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_STATUS_SAQUE.getDescricao());
        }
    }



}
