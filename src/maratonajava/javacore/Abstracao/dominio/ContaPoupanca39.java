package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaPoupanca39 extends Conta39{
    public ContaPoupanca39(Cliente39 cliente39, int numeroConta, double saldo, TipoConta39 tipoConta39, StatusConta39 statusConta39) {
        super(cliente39, numeroConta, saldo, tipoConta39, statusConta39);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta39 == StatusConta39.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoContaCorrente39.SAQUE.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoContaCorrente39.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaCorrente39.ERRO_SAQUE.getDescricao());
    }


    public enum MensagensValidacaoContaCorrente39{
        SAQUE("Saque efetuado no valor de R$%.2f."),
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
