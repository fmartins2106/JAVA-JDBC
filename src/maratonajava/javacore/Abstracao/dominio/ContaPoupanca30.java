package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca30 extends Conta30{
    public ContaPoupanca30(Cliente30 cliente30, int numeroConta, double saldo, TipoConta30 tipoConta30, StatusConta30 statusConta30) {
        super(cliente30, numeroConta, saldo, tipoConta30, statusConta30);
    }

    @Override
    public void sacar(double valor){
        if (statusConta30 == StatusConta30.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoConta30.SAQUE_CP.getDescricaoFormadatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta30.ERRO_VALOR_SAQUE.getDescricaoFormadatada(getSaldo()));
            }
        }else {
            System.out.println(MensagensValidacaoConta30.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }
}






