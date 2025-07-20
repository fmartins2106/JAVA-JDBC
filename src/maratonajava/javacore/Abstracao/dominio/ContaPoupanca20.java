package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca20 extends Conta20{
    public ContaPoupanca20(Cliente20 cliente20, int numeroConta, double saldo, Cliente20.TipoConta20 tipoConta20, Cliente20.StatusConta20 statusConta20) {
        super(cliente20, numeroConta, saldo, tipoConta20, statusConta20);
    }

    public void sacar(double valor){
        if (statusConta20 == Cliente20.StatusConta20.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(Cliente20.MensagensValidacaoCliente20.SAQUE_CP.getDescricao());
            }else {
                System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(Cliente20.MensagensValidacaoCliente20.ERRO_STATUS_SAQUE.getDescricao());
        }
    }
}
