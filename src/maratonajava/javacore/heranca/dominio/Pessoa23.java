package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Pessoa23 {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa23(String nome, String cpf, int idade) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
    }

    public static final int IDADE_MINIMA = 6;

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoPessoa23.ERRO_NOME.getDescricao());
        }
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

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoPessoa23.ERRO_CPF.getDescricao());
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

    public static void validacaoIdade(int idade){
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MensagensValidacaoPessoa23.ERRO_IDADE.getDescricaoFormatada(IDADE_MINIMA));
        }
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validacaoIdade(idade);
        this.idade = idade;
    }

    public enum MensagensValidacaoPessoa23{
        ERRO_NOME("Digite nome completo, campo nome não pode ser vazio ou conter caracteres."),
        ERRO_MATRICULA("Matrícula não pode ser menor que %d."),
        ERRO_MATRICULA_DUPLICADA("Matrícula já cadastrada. Tente outro número de matrícula."),
        ERRO_NOTA("Nota não pode ser menor que %.2f ou maior que %.2f."),
        ERRO_DISCIPLINA("Campo disciplina não pode ficar vazio ou conter caracteres."),
        ERRO_SALARIO_PROFESSOR("Salário não pode ser menor que R$%.2f."),
        ERRO_CPF("CPF inválido."),
        ERRO_IDADE("Idade não pode ser menor que %d.");

        private final String descricao;

        MensagensValidacaoPessoa23(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Idade: %d",nome,cpf,idade);
    }
}
