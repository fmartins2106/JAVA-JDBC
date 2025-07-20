package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente08 extends Conta08{
    private static final double TAXA_SAQUE =5;

    public ContaCorrente08(Cliente08 cliente08, int numeroConta, double saldo, Cliente08.TipoContaBanco tipoContaBanco, Cliente08.StatusContaBanco statusContaBanco) {
        super(cliente08, numeroConta, saldo, tipoContaBanco, statusContaBanco);
    }

    @Override
    public void saque(double valor){
        if (statusContaBanco == Cliente08.StatusContaBanco.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println("Saque de R$"+valor+" realizado com sucesso. Taxa  de R$"+TAXA_SAQUE+" aplicada.");
            }else {
                System.out.println(Cliente08.ErrorMessage.ERRO_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente08.ErrorMessage.CONTA_INATIVA.getDescricao());
        }
    }
}
