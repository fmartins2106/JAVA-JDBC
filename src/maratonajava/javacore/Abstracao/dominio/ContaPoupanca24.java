package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class ContaPoupanca24 extends Conta24{
    public ContaPoupanca24(Cliente24 cliente24, int numeroConta, double saldo, Cliente24.TipoConta24 tipoConta24, Cliente24.StatusConta24 statusConta24) {
        super(cliente24, numeroConta, saldo, tipoConta24, statusConta24);
    }

    @Override
    public void sacar(double valor){
        if (statusConta24 == Cliente24.StatusConta24.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoConta24.SAQUE_CP_REALIZADO.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoConta24.ERRO_VALOR_SAQUE.getDescricao());
            }
        }else {
            System.out.println(MensagensValidacaoConta24.ERRO_STATUS_CONTA_SAQUE.getDescricao());
        }
    }
}
