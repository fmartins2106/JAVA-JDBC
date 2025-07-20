package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaPoupanca38 extends Conta38{
    public ContaPoupanca38(Cliente38 cliente38, int numeroConta, double saldo, TipoConta38 tipoConta38, StatusConta38 statusConta38) {
        super(cliente38, numeroConta, saldo, tipoConta38, statusConta38);
    }

    @Override
    public void sacar(double valor){
        if (statusConta38 == StatusConta38.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoContaPoupanca38.SACAR.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoContaPoupanca38.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaPoupanca38.ERRO_SAQUE.getDescricao());
    }


    public enum MensagensValidacaoContaPoupanca38{
        SACAR("Saque efetuado com sucesso no valor de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaPoupanca38(String descricao) {
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
