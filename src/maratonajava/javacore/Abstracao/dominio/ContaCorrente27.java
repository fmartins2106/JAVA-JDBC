package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente27 extends Conta27{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente27(Cliente27 cliente27, int numeroConta, double saldo, TipoConta27 tipoConta27, StatusConta27 statusConta27) {
        super(cliente27, numeroConta, saldo, tipoConta27, statusConta27);
    }

    @Override
    public void sacar(double valor){
        if (statusConta27 == StatusConta27.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoConta27.SAQUE.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoConta27.ERRO_VALOR_SAQUE.getDescricaoFormatada(getSaldo()));
            }
        }else {
            System.out.println(MensagensValidacaoConta27.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
