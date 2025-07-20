package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Pessoa29 {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa29(String nome, String cpf, int idade) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("\\p{L}+( \\p{L}+)+$")){
            throw new IllegalArgumentException(MensagensValidacaoPessoa29.NOME.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()+
                palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validandoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoPessoa29.CPF.getDescricao());
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

    private static final int MENOR_IDADE = 6;

    public static void validandoIdade(int idade){
        if (idade < MENOR_IDADE){
            throw new IllegalArgumentException(MensagensValidacaoPessoa29.IDADE.getDescricaoFormatada(MENOR_IDADE));
        }
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
        validandoCpf(cpf);
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validandoIdade(idade);
        this.idade = idade;
    }

    public enum MensagensValidacaoPessoa29{
        NOME("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres."),
        CPF("CPF inválido."),
        IDADE("Idade não pode ser menor que %d.");

        private final String descricao;

        MensagensValidacaoPessoa29(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Idade: %d",nome,cpf,idade);
    }
}
