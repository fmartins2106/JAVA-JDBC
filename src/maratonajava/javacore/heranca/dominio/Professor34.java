package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.ProfessorDisciplinaInvalida34;
import academy.devdojo.maratonajava.javacore.excessoes.ProfessorSalarioInvalido34;

public class Professor34 extends Pessoa34{
    private String disciplina;
    private double salario;

    public Professor34(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new ProfessorDisciplinaInvalida34();
        }
    }

    public static void validacaoSalarioProfessor(double salario){
        if (salario < ProfessorSalarioInvalido34.SALARIO_MINIMO_PROFESSOR){
            throw new ProfessorSalarioInvalido34();
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        validacaoDisciplina(disciplina);
        this.disciplina = formatoString(disciplina);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalarioProfessor(salario);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$%.2f",disciplina,salario);
    }
}
