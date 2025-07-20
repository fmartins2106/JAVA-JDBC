package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente35 extends Conta35{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente35(Cliente35 cliente35, int numeroConta, double saldo, TipoConta35 tipoConta35, StatusConta35 statusConta35) {
        super(cliente35, numeroConta, saldo, tipoConta35, statusConta35);
    }

    @Override
    public void sacar(double valor){
        if (statusConta35 == StatusConta35.ATIVA){
            if (valor + TAXA_SAQUE <=  saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoContaCorrente35.SACAR.getDescricaoFormatada(valor,TAXA_SAQUE));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente35.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente35.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaCorrente35{
        SACAR("Saque realizado no valor de R$%.2f. Taxa de R$%.2f aplicada."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo em conta de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaCorrente35(String descricao) {
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
