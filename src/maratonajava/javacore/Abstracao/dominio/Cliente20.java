package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class Cliente20 {
    private String nome;
    private String cpf;

    public Cliente20(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoCliente20.ERRO_NOME.getDescricao());
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
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoCliente20.ERRO_CPF.getDescricao());
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
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma =0;
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
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public enum MensagensValidacaoCliente20{
        ERRO_NOME("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres."),
        DIGITOS_CONTA("Conta inválida. Conta precisa ter %d digitos para ser válida."),
        CONTA_DUPLICADA("Número de conta já cadastrado."),
        ERRO_SALDO("Saldo não pode ser menor que R$%.2f."),
        DEPOSITO_REALIZADO("Depósito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Operação inválida, valor não pode ser menor que R$%.2f."),
        ERRO_STATUS_CONTA_DEPOSITO("Operação inválida. Status da conta precisa estar ativa. Verifique !"),
        BLOQUEIO_CONTA("Conta bloqueada com sucesso."),
        CANCELAMENTO_CONTA("Conta cancelada com sucesso."),
        ERRO_CANCELAMENTO_SALDO("Para efetuar o cancelamento da conta, o saldo precisa ser igual a %.2f"),
        DESBLOQUEIO_CONTA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação negada. Verifique status da conta. Pode já estar bloqueada ou cancelada."),
        ERRO_CONTA_CANCELADA("Operação negada, verifique status da conta, já pode estar bloqueada ou cancelada."),
        ERRO_CONTA_DESBLOQUEADA("Operação negada. Verifique status conta. Conta pode estar cancelada ou ativa."),
        SAQUE("Saque de R$%.2f efetuado com sucesso. Taxa de R$%.2f aplicada."),
        SAQUE_CP("Saque de R$%.2f efetuado com sucesso."),
        ERRO_VALOR_SAQUE("Operação negada. Valor inválido. valor precisa ser menor que saldo de R$%.2f"),
        ERRO_STATUS_SAQUE("Operação negada. Verifique status da conta. Conta pode estar cancelada ou bloqueada."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagensValidacaoCliente20(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta20{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta20{
        ATIVA, BLOQUEADA, CANCELADA;
    }

}
