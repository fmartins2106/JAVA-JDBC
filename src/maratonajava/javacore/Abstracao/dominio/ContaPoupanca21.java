package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca21 extends Conta21{
    public ContaPoupanca21(Cliente21 cliente21, int numeroConta, double saldo, Cliente21.TipoConta21 tipoConta21, Cliente21.StatusConta21 statusConta21) {
        super(cliente21, numeroConta, saldo, tipoConta21, statusConta21);
    }

    @Override
    public void sacar(double valor){
        if (statusConta21 == Cliente21.StatusConta21.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(Cliente21.MensagensValidacaoCliente21.SAQUE_REALIZADO_CC.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente21.MensagensValidacaoCliente21.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }
}
