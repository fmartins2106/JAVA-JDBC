package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca27 extends Conta27{
    public ContaPoupanca27(Cliente27 cliente27, int numeroConta, double saldo, TipoConta27 tipoConta27, StatusConta27 statusConta27) {
        super(cliente27, numeroConta, saldo, tipoConta27, statusConta27);
    }

    @Override
    public void sacar(double valor){
        if (statusConta27 == StatusConta27.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoConta27.SAQUE_CP.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta27.ERRO_VALOR_SAQUE.getDescricaoFormatada(getSaldo()));
            }
        }else {
            System.out.println(MensagensValidacaoConta27.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
