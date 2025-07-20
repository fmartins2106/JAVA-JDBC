package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente38 extends Conta38{
    private static final double TAXA_SAQUE = 5;
    public ContaCorrente38(Cliente38 cliente38, int numeroConta, double saldo, TipoConta38 tipoConta38, StatusConta38 statusConta38) {
        super(cliente38, numeroConta, saldo, tipoConta38, statusConta38);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta38 == StatusConta38.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoContaCorrente38.SACAR.getDescricaoFormatada(valor,TAXA_SAQUE));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente38.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente38.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaCorrente38{
        SACAR("Saque efetuado com sucesso no valor de R$%.2f. Taxa de R$%.2f aplicada."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaCorrente38(String descricao) {
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
