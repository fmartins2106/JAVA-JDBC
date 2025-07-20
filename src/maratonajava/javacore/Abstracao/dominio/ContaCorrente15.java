package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente15 extends Conta15{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente15(Cliente15 cliente15, int numeroConta, double saldo, Cliente15.TipoConta15 tipoConta15, Cliente15.StatusConta15 statusConta15) {
        super(cliente15, numeroConta, saldo, tipoConta15, statusConta15);
    }

    @Override
    public void sacar(double valor){
        if (statusConta15 == Cliente15.StatusConta15.ATIVA){
            if (valor +TAXA_SAQUE <= saldo){
                saldo -= (valor+TAXA_SAQUE);
                System.out.println("Saque de R$"+saldo+ " realizado com sucesso. Taxa de R$"+TAXA_SAQUE+" aplicado com sucesso.");
            }else {
                System.out.println(Cliente15.MensagensErroCliente15.ERRO_SAQUE_VALOR_INVALIDO.getDescricao());
            }
        }else {
            System.out.println(Cliente15.MensagensErroCliente15.ERRO_SAQUE_CONTA_INATIVA.getDescricao());
        }
    }

}
