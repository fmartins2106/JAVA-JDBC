package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class Cliente18 {
    private String nome;
    private String cpf;

    public Cliente18(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoCliente18.ERRO_NOME.getDescricao());
        }
    }

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoCliente18.ERRO_CPF.getDescricao());
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

    public enum MensagensValidacaoCliente18{
        ERRO_NOME("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_DIGITOS_CONTA("Conta precisa ter %d digitos para ser valida."),
        ERRO_CONTA_REPETIDA("Conta já cadastrada, tente outro número de conta."),
        ERRO_SALDO("Saldo não pode ser menor que R$%.2f."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_BLOQUEADA("Operação inválida. Verifique o status da sua conta. Conta pode já estar bloqueada ou cancelada."),
        ERRO_DESBLOQUIO_CONTA("Operação inválida, conta já está ativa ou cancelada, verifique estatus !"),
        ERRO_CANCELAMENTO_CONTA("Para efeutar o cancelamento da conta, seu saldo precisa ser igual a R$%.2f"),
        SAQUE_REALIZADO("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        ERRO_SAQUE_VALOR("Operação não pode ser realizada. Valor maior que saldo em conta. "),
        ERRO_SAQUE_STATUS_CONTA("Operação não realizada. Conta precisa estar ativa. verifique."),
        SAQUE_POUPANCA("Saque de R$%.2f realizado com sucesso."),
        DEPOSITO_REALIZADO("Deposito de R$%.2f realizado com sucesso."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagensValidacaoCliente18(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta18{
        CORRENTE, POUPANCA;
    }

    public enum StatusConta18{
        ATIVA, BLOQUEADA, CANCELADA;
    }
}
