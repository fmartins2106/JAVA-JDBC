package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca10 extends Conta10{

    public ContaPoupanca10(Cliente10 cliente10, int numeroConta, double saldo, Cliente10.TipoConta10 tipoConta10, Cliente10.StatusConta10 statusConta10) {
        super(cliente10, numeroConta, saldo, tipoConta10, statusConta10);
    }

    @Override
    public void transferencia(double valor){
        if (statusConta10 == Cliente10.StatusConta10.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println("Valor de R$" +valor+" transferido com sucesso.");
            }else {
                System.out.println(Cliente10.ErrosValidados.ERR0_TRANSFERENCIA.getDescricao());
            }
        }else {
            System.out.println(Cliente10.ErrosValidados.ERRO_TRANSFERENCIA2.getDescricao());
        }
    }
}
