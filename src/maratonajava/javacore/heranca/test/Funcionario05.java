package academy.devdojo.maratonajava.javacore.heranca.test;

import java.util.Scanner;

public class Funcionario05 {
    private String nome;
    private String departamento;
    private int idade;

    public Funcionario05(String nome, String departamento, int idade) {
        setNome(nome);
        setDepartamento(departamento);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoCampoComString(nome);
        this.nome = formatoNome(nome);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        validandoCampoComString(departamento);
        this.departamento = formatoNome(departamento);
    }

    public int getIdade() {
        return idade;
    }

    public static final String MENSAGEM_VALIDAAO_IDADE = "Idade mínima não pode ser menor que 18.";
    public static final int IDADE_MINIMA = 18;
    public void setIdade(int idade) {
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_VALIDAAO_IDADE);
        }
        this.idade = idade;
    }

    private static final String MENSAGEM_ERRO_VALIDACAO = "Campo nome não pode ser vazio ou conter caracteres.";

    public void validandoCampoComString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_VALIDACAO);
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

    @Override
    public String toString(){
        return String.format("Nome: %s |Departamento: %s |Idade: %d",nome,departamento,idade);
    }
}
