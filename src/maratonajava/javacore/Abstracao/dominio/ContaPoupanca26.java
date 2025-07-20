package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca26 extends Conta26{
    public ContaPoupanca26(Cliente26 cliente26, int numeroConta, double saldo, TipoConta26 tipoConta26, StatusConta26 statusConta26) {
        super(cliente26, numeroConta, saldo, tipoConta26, statusConta26);
    }

    @Override
    public void sacar(double valor){
        if (statusConta26 == StatusConta26.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoConta26.SAQUE_CP.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta26.ERRO_VALOR_SAQUE.getDescricaoFormatada(getSaldo()));
            }
        }else {
            System.out.println(MensagensValidacaoConta26.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
