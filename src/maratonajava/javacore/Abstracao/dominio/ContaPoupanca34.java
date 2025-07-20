package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaPoupanca34 extends Conta34{

    public ContaPoupanca34(Cliente34 cliente34, int numeroConta, double saldo, TipoConta34 tipoConta34, StatusConta34 statusConta34) {
        super(cliente34, numeroConta, saldo, tipoConta34, statusConta34);
    }

    @Override
    public void sacar(double valor){
        if (statusConta34 == StatusConta34.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoContaPoupanca34.SAQUE.getDescricaoFormatada(valor));
            }else {
                System.out.println(MensagensValidacaoContaPoupanca34.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoContaPoupanca34.ERRO_SAQUE.getDescricao());
        }
    }

    public enum MensagensValidacaoContaPoupanca34{
        SAQUE("Saque efetuado no valor de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_VALOR_SAQUE("Operação negada. Verifique valor do saque. não pode ser maior que saldo em conta de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaPoupanca34(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }
}
