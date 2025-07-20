package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class Cliente22 {
    private String nome;
    private String cpf;

    public Cliente22(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoCliente22.ERRO_NOME.getDescricao());
        }
    }

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoCliente22.ERRO_CPF.getDescricao());
        }
    }

    public static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0:digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public static String formatoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormtadao = new StringBuilder();
        for (String palavra : palavras){
            nomeFormtadao.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormtadao.toString().trim();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoString(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
    }

    public enum MensagensValidacaoCliente22{
        ERRO_NOME("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_NUMERO_CONTA("Conta precisa ter %d digitos para ter validade."),
        CONTA_DUPLIACADA("Número de conta já está cadastrada, tente outro número."),
        ERRO_SALDO("Saldo não pode ser menor que %.2f."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique o status da conta, pode já estar bloqueada ou cancelada."),
        ERRO_CONTA_DESBLOQUEADA("Operação inválida. Verifique o status da conta. Conta pode estar já ativa ou cancelada."),
        ERRO_CONTA_CANCELADA_STATUS("Operação inválida. Verifique status da conta. Conta pode já estar bloqueada ou cancelada."),
        ERRO_CONTA_CANCELADA_SALDO("Operação inválida. Para efetuar o cancelamento, saldo da conta precisa ser igual a R$%.2f"),
        DEPOSITO_REALIZADO("Depósito de R$%.2f realizado com sucesso."),
        VALOR_DEPOSITO_INVALIDO("valor de depósito inválido. Valor do depósito precisa ser maior que R$%.2f."),
        STATUS_DEPOSITO_INVALIDO("Operação inválida. Para efetuar o depósito, conta precisa estar ativa. Verifique status da conta."),
        SAQUE_EFETUADO("Saque de R$%.2f efetuado com sucesso. Taxa de R$%.2f aplicada."),
        ERRO_VALOR_SAQUE("Operação inválida. Valor + taxa não pode ser maior que saldo em conta."),
        ERRO_SAQUE_STATUS_CONTA("Operação inválida. Para efetuar saque, conta precisa estar ativa. Verifique status da conta."),
        SAQUE_CC("Saque de R$%.2f efetuado com sucesso."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagensValidacaoCliente22(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta22{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta22{
        ATIVA, BLOQUEADA, CANCELADA;
    }
}
