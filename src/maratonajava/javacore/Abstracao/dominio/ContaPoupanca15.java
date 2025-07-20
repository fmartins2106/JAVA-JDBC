package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca15 extends Conta15{
    public ContaPoupanca15(Cliente15 cliente15, int numeroConta, double saldo, Cliente15.TipoConta15 tipoConta15, Cliente15.StatusConta15 statusConta15) {
        super(cliente15, numeroConta, saldo, tipoConta15, statusConta15);
    }

    @Override
    public void sacar(double valor){
        if (statusConta15 == Cliente15.StatusConta15.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println("Saque efetuar no valor de R$"+valor+" com sucesso.");
            }else {
                System.out.println(Cliente15.MensagensErroCliente15.ERRO_SAQUE_VALOR_INVALIDO.getDescricao());
            }
        }else {
            System.out.println(Cliente15.MensagensErroCliente15.ERRO_SAQUE_CONTA_INATIVA.getDescricao());
        }
    }

}
