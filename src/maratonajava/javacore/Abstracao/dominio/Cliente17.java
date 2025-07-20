package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.Arrays;

public class Cliente17 {
    private String nome;
    private String cpf;

    public Cliente17(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagemValidacaoCliente17.ERRO_NOME.getDescricao());
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
            throw new IllegalArgumentException(MensagemValidacaoCliente17.ERRO_CPF.getDescricao());
        }
    }

    public static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 -i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0:digito2;

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

    public enum MensagemValidacaoCliente17{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres. Digite nome completo."),
        ERRO_DIGITOS_CONTA("Número de conta precisa ter "+ Conta17.DIGITOS_CONTA+" digitos."),
        ERRO_SALDO("Saldo não pode ser menor que "+Conta17.SALDO_MINIMO+"."),
        CONTA_BOQUEADA("Conta bloqueada com sucesso."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CONTA_BLOQUEADA("ERRO: Verifique estatus da conta, conta pode estar já bloqueada ou cancelada."),
        ERRO_CONTA_DESBLOQUEADA("ERRO: Verifique status da conta. Conta já pode estar ativa ou cancelada."),
        ERRO_CONTA_CANCELADA("ERRO: Verifique status da conta. Conta já pode estar cancelada ou bloqueada."),
        ERRO_CONTA_CANCELADA2("Para efetuar o cancelamento da conta, seu saldo precisa ser igual a "+Conta17.SALDO_MINIMO+"."),
        DEPOSITO("Deposito de R$%.2f realizado com sucesso."),
        ERRO_VALOR_DEPOSITO("Operação negada, valor inválido."),
        ERRO_STATUS_DEPOSITO("Operação negada. Verifique o status da conta. Conta pode estar bloqueada ou cancelada."),
        SAQUE_CORRENTE("Saque de R$%.2f realizado com sucesso. Taxa de R$%.2f aplicado."),
        SAQUE_POUPANCA("Saque de R$%.2f realizado com sucesso"),
        ERRO_SALDO_SAQUE("Operação inválida, valor do saque precisa ser menor que saldo."),
        ERRO_CONTA_SAQUE("Operação inválida, verifique status da conta, pode estar cancelada ou bloqueada."),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagemValidacaoCliente17(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFortatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    public enum TipoConta17{
        CORRENTE, POUPANCA;
    }

    public enum StatusConta17{
        ATIVA, BLOQUEADA, CANCELADA;
    }
}
