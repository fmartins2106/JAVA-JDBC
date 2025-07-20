package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente29 extends Conta29{
    private static final double TAXA_SAQUE = 5;
    public ContaCorrente29(Cliente29 cliente29, int numeroConta, double saldo, TipoConta29 tipoConta29, StatusConta29 statusConta29) {
        super(cliente29, numeroConta, saldo, tipoConta29, statusConta29);
    }

    @Override
    public void sacar(double valor){
        if (statusConta29 == StatusConta29.ATIVA){
            if (valor+TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoConta29.SAQUE_REALIZADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoConta29.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoConta29.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
