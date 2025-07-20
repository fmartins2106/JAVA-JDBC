package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente12 extends Conta12{
    private static final double TAXA_MINIMA = 5;

    public ContaCorrente12(Cliente12 cliente12, int numeroConta, double saldo, Cliente12.TipoConta12 tipoConta12, Cliente12.StatusConta12 statusConta12) {
        super(cliente12, numeroConta, saldo, tipoConta12, statusConta12);
    }

    @Override
    public void sacar(double valor){
        if (statusConta12 != Cliente12.StatusConta12.ATIVA){
            System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_SAQUE.getDescricao());
        }else {
            if (valor +TAXA_MINIMA <= saldo){
                saldo-= (valor+TAXA_MINIMA);
                System.out.println(Cliente12.ValidanacaoErrosCliente12.SAQUE.getDescricao());
            }else {
                System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_VALOR_SAQUE.getDescricao());
            }
        }
    }
}
