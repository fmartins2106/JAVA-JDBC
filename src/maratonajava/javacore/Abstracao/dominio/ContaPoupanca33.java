package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca33 extends Conta33{
    public ContaPoupanca33(Cliente33 cliente33, int numeroConta, double saldo, TipoConta33 tipoConta33, StatusConta33 statusConta33) {
        super(cliente33, numeroConta, saldo, tipoConta33, statusConta33);
    }

    @Override
    public void sacar(double valor){
        if (statusConta33 == StatusConta33.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoConta33.SAQUE_REALIZADO_CP.getDescricaoFormatada(valor));

            }else {
                System.out.println(MensagensValidacaoConta33.ERRO_SAQUE_VALOR.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoConta33.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }
}
