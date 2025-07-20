package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca29 extends Conta29{
    public ContaPoupanca29(Cliente29 cliente29, int numeroConta, double saldo, TipoConta29 tipoConta29, StatusConta29 statusConta29) {
        super(cliente29, numeroConta, saldo, tipoConta29, statusConta29);
    }

    @Override
    public void sacar(double valor){
        if (statusConta29 == StatusConta29.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoConta29.SAQUE_CP.getDescricaoFormatada(valor));
            }else{
                System.out.println(MensagensValidacaoConta29.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoConta29.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }

}
