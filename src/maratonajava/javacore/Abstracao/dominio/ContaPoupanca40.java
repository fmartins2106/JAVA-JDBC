package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaPoupanca40 extends Conta40{
    public ContaPoupanca40(Cliente40 cliente40, int numeroConta, double saldo, TipoConta40 tipoConta40, StatusConta40 statusConta40) {
        super(cliente40, numeroConta, saldo, tipoConta40, statusConta40);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta40 == StatusConta40.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoContaPoupanca40.SACAR.getDescricaoFormatada(valor));
                return;
            }
            System.out.println(MensagensValidacaoContaPoupanca40.ERRO_VALOR_SAQUE.getDescricaoFormatada(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaPoupanca40.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaPoupanca40{
        SACAR("Saque realizado no valor de R$%.2f."),
        ERRO_SAQUE("Saque inválido. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque deve ser menor que saldo de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaPoupanca40(String descricao) {
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
