package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente31 extends Conta31{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente31(Cliente31 cliente31, int numeroConta, double saldo, TipoConta31 tipoConta31, StatusConta31 statusConta31) {
        super(cliente31, numeroConta, saldo, tipoConta31, statusConta31);
    }

    @Override
    public void sacar(double valor){
        if (statusConta31 == StatusConta31.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoConta31.SAQUE.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoConta31.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoConta31.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
