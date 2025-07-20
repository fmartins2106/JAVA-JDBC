
package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca18 extends Conta18{
    public ContaPoupanca18(Cliente18 cliente18, int numeroConta, double saldo, Cliente18.TipoConta18 tipoConta18, Cliente18.StatusConta18 statusConta18) {
        super(cliente18, numeroConta, saldo, tipoConta18, statusConta18);
    }

    @Override
    public void sacar(double valor){
        if (statusConta18 == Cliente18.StatusConta18.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(Cliente18.MensagensValidacaoCliente18.SAQUE_POUPANCA.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente18.MensagensValidacaoCliente18.ERRO_SAQUE_VALOR.getDescricao());
            }
        }else {
            System.out.println(Cliente18.MensagensValidacaoCliente18.ERRO_SAQUE_STATUS_CONTA.getDescricao());
        }
    }
}
