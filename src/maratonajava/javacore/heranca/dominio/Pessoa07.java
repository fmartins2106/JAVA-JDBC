package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Pessoa07 {
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa07(String nome, int idade, String cpf) {
        setNome(nome);
        setIdade(idade);
        setCpf(cpf);
    }

    public static final String MENSAGEM_ERRO_NOME = "Campo nome não pode ser vazio ou conter caracteres. Digite nome completo";
    public static final int IDADE_MINIMA = 6;
    public static final String MENSAGEM_ERRO_IDADE = "Idade não pode ser menor que 6. Tente novamente.";
    public static final String MENSAGEM_ERRO_CPF = "CPF inválido. Tente novamente.";

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_NOME);
        }
    }

    private void validacaoIdade(int idade){
        if (idade <IDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_IDADE);
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

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.isEmpty() || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CPF);
        }
    }

    private static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma=0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 -i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 -i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') ==  digito2;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validacaoIdade(idade);
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |Idade: %d |CPF: %s",nome,idade,cpf);
    }
}
