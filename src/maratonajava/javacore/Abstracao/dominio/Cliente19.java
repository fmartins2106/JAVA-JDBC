package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class Cliente19 {
    private String nome;
    private String cpf;

    public Cliente19(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoCliente19.ERRO_NOME.getDescricao());
        }
    }

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoCliente19.ERRO_CPF.getDescricao());
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

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

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

    public enum MensagensValidacaoCliente19{
        ERRO_NOME("Digite nome completo, campo nome não pode ser vazio ou conter caracteres."),
        DIGITOS_CONTA("Conta inválida. Para validar, número de conta precisa ter %d digitos."),
        SALDO_MINIMO("Saldo não pode ser menor que R$%.2f."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        ERRO_CONTA_BLOQUEADA("ERRO: verifique status da conta, conta já pode estar bloqueada ou cancelada."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_CONTA_DESBLOQUEADA("ERRP: verifique status da conta, conta já pode estar ativa ou cancelada."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_CANCELADA("ERRO: verifique status da conta, conta já pode estar cancelada ou bloqueada."),
        DEPOSITO_REALIADO("Deposito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_CALCELAMENTO("Operação inválida, para efetuar o cancelamento, saldo deve ser igual a R$%.2f"),
        ERRO_VALOR_DEPOSITO("Operação inválida. Valor do deposito não pode ser menor que R$%.2f."),
        ERRO_STATUS_DEPOSITO("Operação inválida. Conta precisa estar ativa para relizar esta operação."),
        ERRO_VALOR_SAQUE("ERRO: operação inválida. Valor do saque não pode ser maior que saldo em conta."),
        ERRO_STATUS_SAQUE("ERRO: operação inválida. Conta precisa estar ativa para pode realizar esta operaçao."),
        SAQUE_CC_REALIZADO("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicado."),
        SAQUE_CP_REALIZADO("Saque de R$%.2f realizad com sucesso."),
        NUMERO_CONTA_CADASTRADA("Conta já cadastrada. verifique."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagensValidacaoCliente19(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta19{
        CORRENTE, POUPANÇA;
    }

    public enum StatusConta19{
        ATIVA, BLOQUEADA, CANCELADA;
    }

}
