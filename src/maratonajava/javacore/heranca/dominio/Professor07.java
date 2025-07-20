package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Professor07 extends Pessoa07 {
    private String disciplina;
    private double salario;

    public Professor07(String nome, int idade, String cpf, String disciplina, double salario) {
        super(nome, idade, cpf);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_DISCIPLINA = "Campo disciplina não pode ser vazio ou conter caracteres.";
    public static final double SALARIO_MINIMO_PROFESSOR = 3500;
    public static final String MENSAGEM_ERRO_SALARIO_MINIMO = "Salário professor não pode ser menor que R$3.500";

    private void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO_MINIMO);
        }
    }

    private void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_DISCIPLINA);
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        validacaoDisciplina(disciplina);
        this.disciplina = formatoNome(disciplina);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$ %.2f" , disciplina,salario);
    }
}
