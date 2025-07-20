package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente42 extends Conta42{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente42(Cliente42 cliente42, int numeroConta, double saldo, TipoConta42 tipoConta42, StatusConta42 statusConta42) {
        super(cliente42, numeroConta, saldo, tipoConta42, statusConta42);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta42 == StatusConta42.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoContaCorrente42.SAQUE.getDescricaoCompleta(valor,TAXA_SAQUE));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente42.ERRO_VALOR_SAQUE.getDescricaoCompleta(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente42.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaCorrente42{
        SAQUE("Saque relizado no valor de R$%.2f. Taxa de R$%.2f aplicada com sucesso."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaCorrente42(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoCompleta(double... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }


}
