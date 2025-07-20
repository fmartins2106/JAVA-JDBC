package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca08 extends Conta08{
    public ContaPoupanca08(Cliente08 cliente08, int numeroConta, double saldo, Cliente08.TipoContaBanco tipoContaBanco, Cliente08.StatusContaBanco statusContaBanco) {
        super(cliente08, numeroConta, saldo, tipoContaBanco, statusContaBanco);
    }

    @Override
    public void saque(double valor){
        if (statusContaBanco == Cliente08.StatusContaBanco.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println("Saque de R$"+valor+" realizado com sucesso.");
            }else {
                System.out.println(Cliente08.ErrorMessage.ERRO_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente08.ErrorMessage.CONTA_INATIVA.getDescricao());
        }
    }
}
