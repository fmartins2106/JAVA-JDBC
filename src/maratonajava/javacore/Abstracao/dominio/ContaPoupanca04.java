package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca04 extends Conta04{
    public ContaPoupanca04(Cliente04 cliente04, int numeroConta, double saldo, Cliente04.TipoConta tipoConta, Cliente04.StatusConta statusConta) {
        super(cliente04, numeroConta, saldo, tipoConta, statusConta);
    }

    @Override
    public void saque(double valor){
        if (statusConta != Cliente04.StatusConta.ATIVA){
            System.out.println(Cliente04.ValidacaoDescricao.ERRO_CONTA_INATIVA);
            return;
        }
        if (valor <= SALDO_MINIMO_CONTA){
            saldo -=  valor;
            System.out.println("Saque realizado no valor de R$"+valor);
        }else {
            System.out.println("Saque negada, valor do saque precisa ser amior que saldo em conta.");
        }
    }



}
