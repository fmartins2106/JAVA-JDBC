package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CpfPessoaInvalido33;
import academy.devdojo.maratonajava.javacore.excessoes.IdadePessoaInvalida33;
import academy.devdojo.maratonajava.javacore.excessoes.PessoaNomeInvalido33;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Pessoa33 {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa33(String nome, String cpf, int idade) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^\\p{L}+( \\p{L}+)+$")){
            throw new PessoaNomeInvalido33();
        }
    }

    public static String formatoNome(String nome){
        return Arrays.stream(nome.toLowerCase().split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1)).collect(Collectors.joining(" "));
    }

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new CpfPessoaInvalido33();
        }
    }

    public static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public static void validacaoIdade(int idade){
        if (idade < IdadePessoaInvalida33.MENOR_IDADE){
            throw new IdadePessoaInvalida33();
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

    @Override
    public String toString(){
        return String.format("Nome: %s |Cpf: %s |Idade: %d.",nome,cpf,idade);
    }

}
