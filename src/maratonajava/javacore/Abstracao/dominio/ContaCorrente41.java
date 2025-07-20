package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente41 extends Conta41{
    private static final double TAXA_SALDO = 5;

    public ContaCorrente41(Cliente41 cliente41, int numeroConta, double saldo, TipoConta41 tipoConta41, StatusConta41 statusConta41) {
        super(cliente41, numeroConta, saldo, tipoConta41, statusConta41);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta41 == StatusConta41.ATIVA){
            if (valor + TAXA_SALDO <= saldo){
                saldo -= (valor+TAXA_SALDO);
                System.out.println(MensagensValidacaoContaCorrente41.SAQUE.getDescricaoFormatada(valor,TAXA_SALDO));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente41.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente41.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaCorrente41{
        SAQUE("Saque realizado no valor de R$%.2f. Taxa aplicada no valor de R$%.2f."),
        ERRO_VALOR_SAQUE("Operação negada. Valor inválido. Valor não pode ser maior que saldo de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada.");

        private final String descricao;

        MensagensValidacaoContaCorrente41(String descricao) {
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
