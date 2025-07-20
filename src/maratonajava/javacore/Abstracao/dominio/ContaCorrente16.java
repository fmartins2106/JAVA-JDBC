package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaCorrente16 extends Conta16{
    public static final double TAXA_SAQUE = 5;

    public ContaCorrente16(Cliente16 cliente16, int numeroConta, double saldo, Cliente16.TipoContaCliente16 tipoContaCliente16, Cliente16.StatusContaCliente16 statusContaCliente16) {
        super(cliente16, numeroConta, saldo, tipoContaCliente16, statusContaCliente16);
    }

    @Override
    public void sacar(double valor){
        if (statusContaCliente16 == Cliente16.StatusContaCliente16.ATIVO){
            if ( valor + TAXA_SAQUE <= saldo){
                    saldo -= (valor+TAXA_SAQUE);
                System.out.println(Cliente16.MensagensValidacaoCliente16.SAQUE_CC.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(Cliente16.MensagensValidacaoCliente16.ERR0_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_STATUS_SAQUE.getDescricao());
        }
    }

}
