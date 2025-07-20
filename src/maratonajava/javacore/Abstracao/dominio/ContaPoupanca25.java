package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca25 extends Conta25{
    public ContaPoupanca25(Cliente25 cliente25, int numeroConta, double saldo, TipoConta25 tipoConta25, StatusConta25 statusConta25) {
        super(cliente25, numeroConta, saldo, tipoConta25, statusConta25);
    }

    @Override
    public void sacar(double valor){
        if (statusConta25 == StatusConta25.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoConta25.SAQUE_REALIZADO_CP.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta25.ERRO_VALOR_SAQUE.getDescricaoFormatada(getSaldo()));
            }
        }else {
            System.out.println(MensagensValidacaoConta25.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}

