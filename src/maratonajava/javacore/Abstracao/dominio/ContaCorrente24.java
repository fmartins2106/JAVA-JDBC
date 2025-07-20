package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente24 extends Conta24{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente24(Cliente24 cliente24, int numeroConta, double saldo, Cliente24.TipoConta24 tipoConta24, Cliente24.StatusConta24 statusConta24) {
        super(cliente24, numeroConta, saldo, tipoConta24, statusConta24);
    }

    @Override
    public void sacar(double valor){
        if (statusConta24 == Cliente24.StatusConta24.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoConta24.SAQUE_REALIZADO.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoConta24.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta24.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
