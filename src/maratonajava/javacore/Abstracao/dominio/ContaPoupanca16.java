package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca16 extends Conta16{
    public ContaPoupanca16(Cliente16 cliente16, int numeroConta, double saldo, Cliente16.TipoContaCliente16 tipoContaCliente16, Cliente16.StatusContaCliente16 statusContaCliente16) {
        super(cliente16, numeroConta, saldo, tipoContaCliente16, statusContaCliente16);
    }

    @Override
    public void sacar(double valor){
        if (statusContaCliente16 == Cliente16.StatusContaCliente16.ATIVO){
            if (valor < saldo){
                saldo -= valor;
                System.out.println(Cliente16.MensagensValidacaoCliente16.SAQUE_CP.getDescricaoFormatada(valor));
            }else {
                System.out.println(Cliente16.MensagensValidacaoCliente16.ERR0_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_STATUS_SAQUE.getDescricao());
        }
    }
}
