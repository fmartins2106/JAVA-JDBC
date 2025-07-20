package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca17 extends Conta17{

    public ContaPoupanca17(Cliente17 cliente17, int numeroConta, double saldo, Cliente17.TipoConta17 tipoConta17, Cliente17.StatusConta17 statusConta17) {
        super(cliente17, numeroConta, saldo, tipoConta17, statusConta17);
    }

    @Override
    public void sacar(double valor){
        if (statusConta17 == Cliente17.StatusConta17.ATIVA){
            if (valor <= saldo){
                saldo-=valor;
                System.out.println(Cliente17.MensagemValidacaoCliente17.SAQUE_POUPANCA.getDescricao());
            }else {
                System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_SALDO_SAQUE.getDescricaoFortatada(valor));
            }
        }else {
            System.out.println(Cliente17.MensagemValidacaoCliente17.ERRO_CONTA_SAQUE.getDescricao());
        }
    }

}
