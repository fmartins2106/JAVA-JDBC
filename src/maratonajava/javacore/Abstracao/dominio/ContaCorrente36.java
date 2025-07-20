package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente36 extends Conta36{
    private static final double TAXA_SAQUE = 5;

    public ContaCorrente36(Cliente36 cliente36, int numeroConta, double saldo, TipoConta36 tipoConta36, StatusConta36 statusConta36) {
        super(cliente36, numeroConta, saldo, tipoConta36, statusConta36);
    }

    @Override
    public void sacar(double valor){
        if (statusConta36 == StatusConta36.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor + TAXA_SAQUE);
                System.out.println(MensagensValidacaoContaCorrente36.SACAR.getDescricaoFormatada(valor,TAXA_SAQUE));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente36.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente36.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaCorrente36{
        SACAR("Saque realizado no valor de R$%.2f. Taxa aplicada de R$%.2f."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que o saldo ->R$%.2f"),
        ERRO_SAQUE("Operação negada. Verifique o status da conta.");

        private final String descricao;

        MensagensValidacaoContaCorrente36(String descricao) {
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
