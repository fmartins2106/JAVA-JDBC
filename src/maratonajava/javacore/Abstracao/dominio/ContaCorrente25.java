package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente25 extends Conta25{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente25(Cliente25 cliente25, int numeroConta, double saldo, TipoConta25 tipoConta25, StatusConta25 statusConta25) {
        super(cliente25, numeroConta, saldo, tipoConta25, statusConta25);
    }

    @Override
    public void sacar(double valor){
        if (statusConta25 == StatusConta25.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoConta25.SAQUE_REALIADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoConta25.ERRO_VALOR_SAQUE.getDescricaoFormatada(getSaldo()));
            }
        }else {
            System.out.println(MensagensValidacaoConta25.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
