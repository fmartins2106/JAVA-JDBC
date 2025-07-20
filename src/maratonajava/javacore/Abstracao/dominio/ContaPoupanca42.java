package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class ContaPoupanca42 extends Conta42{
    public ContaPoupanca42(Cliente42 cliente42, int numeroConta, double saldo, TipoConta42 tipoConta42, StatusConta42 statusConta42) {
        super(cliente42, numeroConta, saldo, tipoConta42, statusConta42);
    }

    @Override
    public void sacar(double valor) {
        if (statusConta42 == StatusConta42.ATIVA){
            if (valor <= saldo){
                saldo -= valor;
                System.out.println(MensagensValidacaoContaPoupanca42.SAQUE.getDescricaoCompleta(valor));
                return;
            }
            System.out.println(MensagensValidacaoContaPoupanca42.ERRO_VALOR_SAQUE.getDescricaoCompleta(saldo));
            return;
        }
        System.out.println(MensagensValidacaoContaPoupanca42.ERRO_SAQUE.getDescricao());
    }

    public enum MensagensValidacaoContaPoupanca42{
        SAQUE("Saque relizado no valor de R$%.2f."),
        ERRO_SAQUE("Operação negada. Verifique status da conta. Conta pode estar bloqueada ou cancelada."),
        ERRO_VALOR_SAQUE("Operação negada. Valor do saque não pode ser maior que saldo de R$%.2f.");

        private final String descricao;

        MensagensValidacaoContaPoupanca42(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoCompleta(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }
}
