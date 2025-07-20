package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Cliente11 {
    private String nome;
    private String cpf;

    public Cliente11(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
    }

    public void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacao11.ERRO_NOME.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras ){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacao11.ERRO_CPF.getDescricao());
        }
    }

    private boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma =0;
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
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
    }

    public enum MensagensValidacao11{
        ERRO_NOME("Campo nome não pode ser vaio ou conter caracteres."),
        ERRO_DIGITOS_CONTAS("Conta precisa ter 6 digitos para ser valido."),
        ERRO_SALDO("Saldo não pode ser menor que zero."),
        CONTA_BLOQUEADA("Conta bloqueada com sucesso."),
        CONTA_DESBLOQUEADA("Conta desbloqueada com sucesso."),
        ERRO_DESBLOQUEAR_CONTA("Operação negada. Conta ativa ou cancelada. Verifique."),
        ERRO_DEPOSITO("Para efetuar deposito, sua conta precisa estar ativa, verifique."),
        CONTA_CANCELADA("Conta cancelada com sucesso."),
        ERRO_CANCELAMENTO_CONTA("Para efetuar o cancelamento da conta, seu saldo precisa ser igual a zero."),
        ERRO_VALOR_SAQUE("Valor do saque não pode ser maior que saldo em conta."),
        ERRO_SAQUE("Para efetuar o saque a conta precisa, estar ativa. Verifique"),
        ERRO_CPF("CPF inválido.");

        private final String descricao;

        MensagensValidacao11(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }
    }

    public enum TipoConta11{
        CORRENTE, POUPANCA;
    }

    public enum StatusConta11{
        ATIVA, BLOQUEADA, CALCELADA;
    }

}
