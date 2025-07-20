package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaPoupanca36 extends Conta36 {
    public ContaPoupanca36(Cliente36 cliente36, int numeroConta, double saldo, TipoConta36 tipoConta36, StatusConta36 statusConta36) {
        super(cliente36, numeroConta, saldo, tipoConta36, statusConta36);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta36 == StatusConta36.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoContaPoupanca36.SACAR.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoContaPoupanca36.ERRO_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaPoupanca36.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaPoupanca36{
        SACAR("Saque realizado no valor de R$%.2f."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que o saldo ->R$%.2f"),
        ERRO_SAQUE("Operação negada. Verifique o status da conta.");

        private final String descricao;

        MensagensValidacaoContaPoupanca36(String descricao) {
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
