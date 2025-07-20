package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaCorrente40 extends Conta40{
    private static final double TAXA_SAQUE = 5;
    public ContaCorrente40(Cliente40 cliente40, int numeroConta, double saldo, TipoConta40 tipoConta40, StatusConta40 statusConta40) {
        super(cliente40, numeroConta, saldo, tipoConta40, statusConta40);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta40 == StatusConta40.ATIVA){
            if (valor + TAXA_SAQUE <= saldo){
                saldo -= (valor+TAXA_SAQUE);
                System.out.println(MensagensValidacaoContaCorrente40.SACAR.getDescricaoFormatada(valor,TAXA_SAQUE));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente40.ERRO_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente40.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaCorrente40{
        SACAR("Saque realizado no valor de R$%.2f. Taxa aplicada no valor de R$%.2f."),
        ERRO_SAQUE("Saque inválido. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque deve ser menor que saldo de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaCorrente40(String descricao) {
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
