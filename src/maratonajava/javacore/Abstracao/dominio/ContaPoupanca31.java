package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca31 extends Conta31{
    public ContaPoupanca31(Cliente31 cliente31, int numeroConta, double saldo, TipoConta31 tipoConta31, StatusConta31 statusConta31) {
        super(cliente31, numeroConta, saldo, tipoConta31, statusConta31);
    }

    @Override
    public void sacar(double valor){
        if (statusConta31 == StatusConta31.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoConta31.SAQUE_CP.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta31.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoConta31.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
