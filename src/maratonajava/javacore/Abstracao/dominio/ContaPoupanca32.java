package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca32 extends Conta32{

    public ContaPoupanca32(Cliente32 cliente32, int numeroConta, double saldo, TipoConta32 tipoConta32, StatusConta32 statusConta32) {
        super(cliente32, numeroConta, saldo, tipoConta32, statusConta32);
    }

    @Override
    public void sacar(double valor){
        if (statusConta32 == StatusConta32.ATIVA){
            if (valor <= saldo) {
                saldo -= valor;
                System.out.println(MensagensValidacaoConta32.SAQUE_CP.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta32.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoConta32.ERRO_SAQUE.getDescricao());
        }
    }
}

