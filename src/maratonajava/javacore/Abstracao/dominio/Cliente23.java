package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class Cliente23 {
    private String nome;
    private String cpf;

    public Cliente23(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoCliente23.ERRO_NOME.getDescricao());
        }
    }

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoCliente23.ERRO_CPF.getDescricao());
        }
    }

    private static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i)  - '0') * (10 - i);
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

    public static String formatoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
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

    public enum MensagensValidacaoCliente23{
        ERRO_NOME("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_DIGITOS_CONTA("Erro: conta precisa ter %d digitos para ter validade."),
        ERRO_SALDO("Saldo não pode ser menor que %.2f."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negadada. Verifique status da conta. Conta já pode estar bloqueada ou cancelada."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status da conta. Conta pode já estar ativa ou cancelada."),
        ERRO_CONTA_CANCELADA("Operação negada. Verifique status da conta. Conta já pode estar cancenada ou bloqueada."),
        ERR_CONTA_CANCELADA_SALDO("Operação negada. para efetuar cancelamento, saldo da conta precisa ser igual a R$%.2f"),
        DEPOSITO_REALIZADO("Depósito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Operação negada. Valor do depósito não pode ser menor que R$%.2f"),
        ERRO_STATUS_DEPOSITO("Operação negada. Para efetuar o depósito, Status da conta precisa ser ATIVA. Verifique."),
        SAQUE_REALIZADO("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada. "),
        ERRO_SAQUE_VALOR_SALDO("Valor do saque não pode ser maior que saldo em conta."),
        ERRO_SAQUE_STATUS_CONTA("Conta precisa estar ativa para efetuar a saque. Verifique !!!"),
        SAQUE_REALIZADO_CC("Saque de R$%.2f realizado com sucesso."),
        ERRO_CPF("CPF inválido. Verifique.");

        private final String descricao;

        MensagensValidacaoCliente23(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormadata(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormadata(String... valores){
            return String.format(descricao,(Object[]) valores);
        }

    }

    public enum TipoConta23{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta23{
        ATIVA, BLOQUEADA, CANCELADA;
    }
}
