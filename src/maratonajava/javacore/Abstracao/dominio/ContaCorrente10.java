package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente10 extends Conta10{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente10(Cliente10 cliente10, int numeroConta, double saldo, Cliente10.TipoConta10 tipoConta10, Cliente10.StatusConta10 statusConta10) {
        super(cliente10, numeroConta, saldo, tipoConta10, statusConta10);
    }

    @Override
    public void transferencia(double valor){
        if (statusConta10 == Cliente10.StatusConta10.ATIVA){
            if (valor+TAXA_SAQUE <= saldo){
                saldo -= (valor+TAXA_SAQUE);
                System.out.println("Transferência no valor de R$"+valor+" realizado com sucesso. Taxa de R$"+TAXA_SAQUE+" aplicada.");
            }else {
                System.out.println(Cliente10.ErrosValidados.ERR0_TRANSFERENCIA.getDescricao());
            }
        }else {
            System.out.println(Cliente10.ErrosValidados.ERRO_TRANSFERENCIA2.getDescricao());
        }
    }

}
