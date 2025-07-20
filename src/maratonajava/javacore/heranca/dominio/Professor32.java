package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.ProfessorDisciplinaInvalida32;
import academy.devdojo.maratonajava.javacore.excessoes.ProfessorSalarioInvalido32;

public class Professor32 extends Pessoa32{
    private String disciplina;
    private double salario;

    public Professor32(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("\\p{L}+( \\p{L}+)*$")){
            throw new ProfessorDisciplinaInvalida32();
        }
    }

    public static void validacaoSalario(double salario){
        if (salario < ProfessorSalarioInvalido32.MENOR_SALARIO){
            throw new ProfessorSalarioInvalido32();
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
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$%.2f.",disciplina,salario);
    }
}
