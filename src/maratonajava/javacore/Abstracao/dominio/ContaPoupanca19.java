package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca19 extends Conta19{
    public ContaPoupanca19(Cliente19 cliente19, int numeroConta, double saldo, Cliente19.TipoConta19 tipoConta19, Cliente19.StatusConta19 statusConta19) {
        super(cliente19, numeroConta, saldo, tipoConta19, statusConta19);
    }

    @Override
    public void sacar(double valor){
        if (statusConta19 == Cliente19.StatusConta19.ATIVA){
            if (valor <= saldo){
                saldo-= valor;
                System.out.println(Cliente19.MensagensValidacaoCliente19.SAQUE_CP_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente19.MensagensValidacaoCliente19.ERRO_STATUS_SAQUE.getDescricao());
        }
    }
}

