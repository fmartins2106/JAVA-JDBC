package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca12 extends Conta12 {
    public ContaPoupanca12(Cliente12 cliente12, int numeroConta, double saldo, Cliente12.TipoConta12 tipoConta12, Cliente12.StatusConta12 statusConta12) {
        super(cliente12, numeroConta, saldo, tipoConta12, statusConta12);
    }

    @Override
    public void sacar(double valor){
        if (statusConta12 != Cliente12.StatusConta12.ATIVA){
            System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_SAQUE.getDescricao());
        }else {
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(Cliente12.ValidanacaoErrosCliente12.SAQUE.getDescricao());
            }else {
                System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_VALOR_SAQUE.getDescricao());
            }
        }
    }
}
