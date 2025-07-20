package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaPoupanca35 extends Conta35{
    public ContaPoupanca35(Cliente35 cliente35, int numeroConta, double saldo, TipoConta35 tipoConta35, StatusConta35 statusConta35) {
        super(cliente35, numeroConta, saldo, tipoConta35, statusConta35);
    }

    @Override
    public void sacar(double valor){
        if (statusConta35 == StatusConta35.ATIVA){
            if (valor <=  saldo){
                saldo -= valor;
                System.out.println(MensagenValidacaoPoupanca35.SACAR.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagenValidacaoPoupanca35.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagenValidacaoPoupanca35.ERRO_SAQUE.getDescricao());
    }

    public enum MensagenValidacaoPoupanca35{
        SACAR("Saque realizado no valor de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo em conta de R$%.2f.");

        private final String descricao;

        MensagenValidacaoPoupanca35(String descricao) {
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
