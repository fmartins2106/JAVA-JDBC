package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente07 extends Conta07{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente07(Cliente07 cliente07, int numeroConta, double saldo, Cliente07.TipoContas tipoContas, Cliente07.StatusContas statusContas) {
        super(cliente07, numeroConta, saldo, tipoContas, statusContas);
    }

    @Override
    public void saque(double valor){
        if (statusContas != Cliente07.StatusContas.ATIVA){
            System.out.println(Cliente07.ValidationDescription.ERR0_CONTA_INATIVA.getDescricao());
            return;
        }
        if (valor + TAXA_SAQUE <= saldo){
            saldo -= (valor + TAXA_SAQUE);
            System.out.println("Saque no valor de R$"+valor+" realizado com sucesso. Taxa de R$"+TAXA_SAQUE+" aplicada.");
        }else {
            System.out.println(Cliente07.ValidationDescription.MENSAGEM_ERRO_SAQUE.getDescricao());
        }
    }
}
