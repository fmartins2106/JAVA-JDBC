package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente39 extends Conta39{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente39(Cliente39 cliente39, int numeroConta, double saldo, TipoConta39 tipoConta39, StatusConta39 statusConta39) {
        super(cliente39, numeroConta, saldo, tipoConta39, statusConta39);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta39 == StatusConta39.ATIVA){
            if (valor + TAXA_SAQUE <= saldo) {
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoContaCorrente39.SAQUE.getDescricaoFormatada(valor,TAXA_SAQUE));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente39.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente39.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaCorrente39{
        SAQUE("Saque efetuado no valor de R$%.2f. Taxa aplicada no valor de R$%.2f."),
        ERRO_VALOR_SAQUE("Operação negada.Valor não pode ser maior que saldo de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada.");

        private final String descricao;

        MensagensValidacaoContaCorrente39(String descricao) {
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
