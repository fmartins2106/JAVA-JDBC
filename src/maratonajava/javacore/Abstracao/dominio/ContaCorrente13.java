package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente13 extends Conta13{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente13(Cliente13 cliente13, int numeroConta, double saldo, Cliente13.TipoConta13 tipoConta13, Cliente13.StatusConta13 statusConta13) {
        super(cliente13, numeroConta, saldo, tipoConta13, statusConta13);
    }

    @Override
    public void sacar(double valor){
        if (statusConta13 == Cliente13.StatusConta13.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println("Saque de R$"+valor+" realizado com sucesso. Taxa de R$"+TAXA_SAQUE+" aplicado com sucesso.");
            }else {
                System.out.println("Valor inválido.");
            }
        }else {
            System.out.println(Cliente13.MensagensValidacaoCliente13.ERRO_SAQUE.getDescricao());
        }
    }
}
