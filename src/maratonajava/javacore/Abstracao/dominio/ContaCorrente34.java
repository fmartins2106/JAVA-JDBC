package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente34 extends Conta34{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente34(Cliente34 cliente34, int numeroConta, double saldo, TipoConta34 tipoConta34, StatusConta34 statusConta34) {
        super(cliente34, numeroConta, saldo, tipoConta34, statusConta34);
    }

    @Override
    public void sacar(double valor){
        if (statusConta34 == StatusConta34.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoContaCorrente34.SAQUE.getDescricaoFormatada(valor,TAXA_SAQUE));
            }else {
                System.out.println(MensagensValidacaoContaCorrente34.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            }
        }else {
            System.out.println(MensagensValidacaoContaCorrente34.ERRO_SAQUE.getDescricao());
        }
    }

    public enum MensagensValidacaoContaCorrente34{
        SAQUE("Saque efetuado no valor de R$%.2f. Taxa aplicada no valor de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_VALOR_SAQUE("Operação negada. Verifique valor do saque. não pode ser maior que saldo em conta de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaCorrente34(String descricao) {
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
