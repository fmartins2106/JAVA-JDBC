package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente33 extends Conta33 {
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente33(Cliente33 cliente33, int numeroConta, double saldo, TipoConta33 tipoConta33, StatusConta33 statusConta33) {
        super(cliente33, numeroConta, saldo, tipoConta33, statusConta33);
    }

    @Override
    public void sacar(double valor){
        if (statusConta33 == StatusConta33.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoConta33.SAQUE_REALIZADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoConta33.ERRO_SAQUE_VALOR.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoConta33.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }
}
