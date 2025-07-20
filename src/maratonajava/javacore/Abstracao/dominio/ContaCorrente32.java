package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente32 extends Conta32{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente32(Cliente32 cliente32, int numeroConta, double saldo, TipoConta32 tipoConta32, StatusConta32 statusConta32) {
        super(cliente32, numeroConta, saldo, tipoConta32, statusConta32);
    }

    @Override
    public void sacar(double valor){
        if (statusConta32 == StatusConta32.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoConta32.SAQUE.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoConta32.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoConta32.ERRO_SAQUE.getDescricao());
        }
    }
}
