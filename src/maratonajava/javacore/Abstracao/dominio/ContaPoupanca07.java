package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca07 extends Conta07 {
    public ContaPoupanca07(Cliente07 cliente07, int numeroConta, double saldo, Cliente07.TipoContas tipoContas, Cliente07.StatusContas statusContas) {
        super(cliente07, numeroConta, saldo, tipoContas, statusContas);
    }

    @Override
    public void saque(double valor){
        if (statusContas != Cliente07.StatusContas.ATIVA){
            System.out.println(Cliente07.ValidationDescription.ERR0_CONTA_INATIVA.getDescricao());
            return;
        }
        if (valor <= saldo){
            saldo -= valor;
            System.out.println("Saque de R$"+valor+" realizado com sucesso.");
        }else {
            System.out.println(Cliente07.ValidationDescription.MENSAGEM_ERRO_SAQUE.getDescricao());
        }
    }
}
