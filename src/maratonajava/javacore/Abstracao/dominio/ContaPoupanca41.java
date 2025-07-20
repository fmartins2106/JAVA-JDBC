package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaPoupanca41 extends Conta41{

    public ContaPoupanca41(Cliente41 cliente41, int numeroConta, double saldo, TipoConta41 tipoConta41, StatusConta41 statusConta41) {
        super(cliente41, numeroConta, saldo, tipoConta41, statusConta41);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta41 == StatusConta41.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoContaPoupanca41.SAQUE.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoContaPoupanca41.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaPoupanca41.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaPoupanca41{
        SAQUE("Saque realizado no valor de R$%.2f."),
        ERRO_VALOR_SAQUE("Operação negada. Valor inválido. Valor não pode ser maior que saldo de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada.");

        private final String descricao;

        MensagensValidacaoContaPoupanca41(String descricao) {
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
