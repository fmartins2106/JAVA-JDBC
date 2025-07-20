package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente14 extends Conta14{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente14(Cliente14 cliente14, int numeroConta, double saldoInicial, Cliente14.TipoConta14 tipoConta14, Cliente14.StatusConta14 statusConta14) {
        super(cliente14, numeroConta, saldoInicial, tipoConta14, statusConta14);
    }

    @Override
    public void sacar(double valor){
        if (statusConta14 == Cliente14.StatusConta14.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor+TAXA_SAQUE);
                System.out.println("Saque de R$"+valor+" realizado com sucesso. Taxa de R$"+TAXA_SAQUE+" aplicado com sucesso.");
            }else {
                System.out.println(Cliente14.MensagensErroCliente14.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente14.MensagensErroCliente14.ERRO_STATUS_SAQUE.getDescricao());
        }
    }

}
