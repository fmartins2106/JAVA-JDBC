package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.ProfessorDisciplinaInvalida33;
import academy.devdojo.maratonajava.javacore.excessoes.ProfessorSalarioInvalido33;

public class Professor33 extends Pessoa33{
    private String disciplina;
    private double salario;

    public Professor33(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new ProfessorDisciplinaInvalida33();
        }
    }

    public static void validacaoSalario(double salario){
        if (salario < ProfessorSalarioInvalido33.SALARIO_MINIMO){
            throw new ProfessorSalarioInvalido33();
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
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$%.2f",disciplina,salario);
    }
}
