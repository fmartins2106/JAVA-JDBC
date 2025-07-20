package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca06 extends Conta06{
    public ContaPoupanca06(Cliente06 cliente06, int numeroConta, double saldo, Cliente06.TipoDaConta tipoDaConta, Cliente06.StatusDaConta statusDaConta) {
        super(cliente06, numeroConta, saldo, tipoDaConta, statusDaConta);
    }

    @Override
    public void saque(double valor){
        if (statusDaConta != Cliente06.StatusDaConta.ATIVA){
            System.out.println(Cliente06.Validation.CONTA_INATIVA.getDescricao());
            return;
        }
        if (valor < saldo){
            saldo -= valor;
            System.out.println("Saque de R$"+valor+" realizado com sucesso.");
        }else {
            System.out.println("Valor do saque não pode ser maior que saldo em conta.");
        }
    }

}
