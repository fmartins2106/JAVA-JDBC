package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class Cliente16 {
    private String nome;
    private String cpf;

    public Cliente16(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoCliente16.ERRO_NOME.getDescricao());
        }
    }

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoCliente16.ERRO_CPF.getDescricao());
        }
    }

    public static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(9) - '0') * (10 -i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 =(digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
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

    public enum MensagensValidacaoCliente16{
        ERRO_NOME("Erro: Digite nome completo, campo nome não pode ser vazio ou conter caracteres."),
        ERRO_CPF("CPF inválido."),
        ERRO_VALOR_DEPOSITO("Operação inválida. valor não pode ser menor que zero."),
        ERRO_DEPOSITO_STATUS("Operação inválida, verifique o status da sua conta que pode estár bloqueada ou cancelada."),
        ERRO_SALDO("Saldo não pode ser menor que zero."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("Operação inválida. Conta status pode já cancelada ou bloqueada."),
        ERR0_CONTA_CANCELADA2("Para efetuar o cancelamento da conta, seu saldo precisa estar zerado."),
        SAQUE_CC("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicada."),
        SAQUE_CP("Saque de R$%.2f realizado com sucesso."),
        ERR0_VALOR_SAQUE("Operação inválida, valor de saque não pode ser maior que saldo em conta."),
        ERRO_STATUS_SAQUE("Operação negada, sua conta pode estar bloqueada ou cancelada. Verifique status da conta."),
        ERRO_CONTA_BLOQUEADA("ERRO: verifique estatus da conta. Conta já pode estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("Operação inválida. Conta já pode estar ativa ou bloqueada,verifique."),
        DEPOSITO_REALIZADO("Deposito de R$%.2f realizado com sucesso."),
        ERRO_DIGITOS_CONTA("Número de conta inválido. Número de conta precisa ter 6 digitos.");
        private final String descricao;

        MensagensValidacaoCliente16(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

    }

    public enum TipoContaCliente16{
        CORRENTE, POUPANCA;
    }

    public enum StatusContaCliente16{
        ATIVO, BLOQUEADA, CANCELADA;
    }
}
