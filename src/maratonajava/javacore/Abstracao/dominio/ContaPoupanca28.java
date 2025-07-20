package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca28 extends Conta28{
    public ContaPoupanca28(Cliente28 cliente28, int numeroConta, double saldo, TipoConta28 tipoConta28, StatusConta28 statusConta28) {
        super(cliente28, numeroConta, saldo, tipoConta28, statusConta28);
    }

    @Override
    public void sacar(double valor){
        if (statusConta28 == StatusConta28.ATIVA){
            if (valor <= saldo){
                System.out.println(MensagensValidacaoConta28.SAQUE_CONTACP.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta28.ERRO_VALOR_SAQUE.getDescricaoFormatada(getSaldo()));
            }
        }else {
            System.out.println(MensagensValidacaoConta28.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}

