package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca11 extends Conta11{
    public ContaPoupanca11(Cliente11 cliente11, int numeroConta, double saldo, Cliente11.TipoConta11 tipoConta11, Cliente11.StatusConta11 statusConta11) {
        super(cliente11, numeroConta, saldo, tipoConta11, statusConta11);
    }

    @Override
    public void sacar(double valor){
        if (statusConta11 == Cliente11.StatusConta11.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println("Saque de R$"+valor+" realizado com sucesso.");
            }else {
                System.out.println(Cliente11.MensagensValidacao11.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente11.MensagensValidacao11.ERRO_SAQUE.getDescricao());
        }
    }
}
