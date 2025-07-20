package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Funcionario10 {
    private String nome;
    private int idade;
    private String departamento;

    public Funcionario10(String nome, int idade, String departamento) {
        setNome(nome);
        setIdade(idade);
        setDepartamento(departamento);
    }

    public static final String MENSAGEM_ERRO_NOME = "Campo nome não pode ser vazio ou conter caracteres.";
    public static final int IDADE_MINIMA = 18;
    public static final String MENSAGEM_ERRO_DEPARTAMENTO = "Campo departamento não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_IDADE = "Idade não pode ser menor que 18 anos.";

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_NOME);
        }
    }

    private void validacaoIdade(int idade){
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_IDADE);
        }
    }

    private void validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_DEPARTAMENTO);
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        validacaoDepartamento(departamento);
        this.departamento = formatoNome(departamento);
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |Idade: %d |Departamento: %s",nome,idade,departamento);
    }
}
