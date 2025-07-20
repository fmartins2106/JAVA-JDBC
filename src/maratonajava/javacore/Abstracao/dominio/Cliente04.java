    package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Cliente04 {
    private String nome;
    private String cpf;

    public Cliente04(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
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

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(ValidacaoDescricao.ERRO_NOME.getDescricao());
        }
    }

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(ValidacaoDescricao.ERRO_CPF.getDescricao());
        }
    }

    public boolean isCpfValido(String cpf){
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
        this.nome = formatoNome(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
    }

    public enum ValidacaoDescricao{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_CPF("CPF inválido."),
        ERRO_CONTA("Número da conta precisa ter 6 digitos."),
        ERRO_SALDO("Saldo não pode ser menor que zero."),
        ERRO_CONTA_BLOQUEADA("Conta bloqueada."),
        ERRO_CONTA_ENCERRADA("Conta encerrada."),
        ERR_CANCELAR_CONTA("Conta precisa ter saldo zerado para ser cancelada."),
        ERRO_CONTA_INATIVA("Operação negada, conta inativa.");

        private final String descricao;

        ValidacaoDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum TipoConta{
        CORRENTE, POUPANCA;
    }
    public enum StatusConta{
        ATIVA, CANCELADA, BLOQUEADA;
    }
}
