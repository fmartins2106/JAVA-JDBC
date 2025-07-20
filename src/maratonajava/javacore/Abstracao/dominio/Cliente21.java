package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class Cliente21 {
    private String nome;
    private String cpf;

    public Cliente21(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoCliente21.ERRO_NOME.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoCliente21.ERRO_CPF.getDescricao());
        }
    }

    private static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
    }

    public enum MensagensValidacaoCliente21{
        ERRO_NOME("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_NUMERO_CONTA("Número de conta precisa ter %d digitos para ser validada."),
        NUMERO_CONTA_DUPLICADA("Número de conta duplicada."),
        SALDO_MINIMO("Saldo não pode ser menor que R$%.2f"),
        DEPOSITO("Deposito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Valor inválido. valor de depósito não pode ser menor que R$%.2f"),
        ERRO_STATUS_CONTA_DEPOSITO("Operação inválida. Conta precisa estar ativa para efetuar o depósito."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação inválida. Conta já pode estar bloqueada ou cancelada."),
        ERRO_STATUS_CONTA_DESBLOQUEADA("Operação inválida. Conta já pode estar Ativa ou cancelada. Verifique!"),
        ERRO_STATUS_CONTA_CANCELADA("Operação inválida. Conta já pode estar cancelada ou bloqueada."),
        SAQUE_REALIZADO("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicado."),
        ERRO_VALOR_SAQUE("Operação inválida. Valor de saque não pode ser maior que saldo em conta."),
        ERRO_SAQUE_STATUS_CONTA("Operação inválida. Verifique status da conta, conta pode estar bloqueada ou cancelada."),
        SAQUE_REALIZADO_CC("Saque de R$%.2f realizado com sucesso."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_SALDO_CONTA_CANCELADA("Operação inválida. Para efetuar o cancelamento da conta. o Saldo precisa ser igual a %.2f."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagensValidacaoCliente21(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta21{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta21{
        ATIVA, BLOQUEADA, CANCELADA;
    }
}
