package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente11 extends Conta11 {
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente11(Cliente11 cliente11, int numeroConta, double saldo, Cliente11.TipoConta11 tipoConta11, Cliente11.StatusConta11 statusConta11) {
        super(cliente11, numeroConta, saldo, tipoConta11, statusConta11);
    }

    @Override
    public void sacar(double valor){
        if (statusConta11 == Cliente11.StatusConta11.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor+TAXA_SAQUE);
                System.out.println("Saque de R$ "+valor+" efetuado com sucesso. Taxa de R$"+TAXA_SAQUE+" aplicado.");
            }else {
                System.out.println(Cliente11.MensagensValidacao11.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente11.MensagensValidacao11.ERRO_SAQUE.getDescricao());
        }
    }
}
