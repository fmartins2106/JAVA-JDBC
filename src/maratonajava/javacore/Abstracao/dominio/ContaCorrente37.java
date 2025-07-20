package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente37 extends Conta37{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente37(Cliente37 cliente37, int numeroConta, double saldo, TipoConta37 tipoConta37, StatusConta37 statusConta37) {
        super(cliente37, numeroConta, saldo, tipoConta37, statusConta37);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta37 == StatusConta37.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoContaCorrente37.SACAR.getDescricaoFormatada(valor,TAXA_SAQUE));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente37.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente37.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaCorrente37{
        SACAR("Saque realizado no valor de R$.%.2f. Taxa aplicada no valor de R$.%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_VALOR_SAQUE("Operação negada. Verifique valor do saque. Valor não pode ser maior que saldo de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaCorrente37(String descricao) {
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
