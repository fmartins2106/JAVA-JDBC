package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente09 extends Conta09{
    private static final double TAXA_SAQUE=5;

    public ContaCorrente09(Cliente09 cliente09, int numeroConta, double saldo, Cliente09.TipoContas tipoContas, Cliente09.StatusContas statusContas) {
        super(cliente09, numeroConta, saldo, tipoContas, statusContas);
    }

    @Override
    public void saque(double valor){
        if (statusContas == Cliente09.StatusContas.ATIVA){
            if (TAXA_SAQUE + valor <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println("Saque de R$"+valor+" realizad com sucesso. Taxa saque de R$"+TAXA_SAQUE+" aplicada.");
            }else {
                System.out.println(Cliente09.ErroMensagens.ERRO_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente09.ErroMensagens.ERRO_DEPOSITO.getDescricao());
        }
    }
}
