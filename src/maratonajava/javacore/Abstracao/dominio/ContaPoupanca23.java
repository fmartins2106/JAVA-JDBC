package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca23 extends Conta23{
    public ContaPoupanca23(Cliente23 cliente23, int numeroConta, double saldo, Cliente23.TipoConta23 tipoConta23, Cliente23.StatusConta23 statusConta23) {
        super(cliente23, numeroConta, saldo, tipoConta23, statusConta23);
    }

    @Override
    public void sacar(double valor){
        if (statusConta23 == Cliente23.StatusConta23.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(Cliente23.MensagensValidacaoCliente23.SAQUE_REALIZADO_CC.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_SAQUE_VALOR_SALDO.getDescricao());
            }
        }else {
            System.out.println(Cliente23.MensagensValidacaoCliente23.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }
}
