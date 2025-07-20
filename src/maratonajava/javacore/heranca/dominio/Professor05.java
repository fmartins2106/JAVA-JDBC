package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor05 extends Pessoa05{
    private String disciplina;
    private double salario;

    public Professor05(String nome, int idade, String cpf, String disciplina, double salario) {
        super(nome, idade, cpf);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_DISCIPLINA = "Campo disciplina não pode ser vazio ou conter caracteres.";
    public static final double SALARIO_MINIMO_PROF = 3000;
    public static final String MENSAGEM_ERRO_SALARIO_PROF = "Salário professor não pode ser menor que R$3.000";

    public void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_DISCIPLINA);
        }
    }

    public void validacaoSalarioProfessor(double salario){
        if (salario < SALARIO_MINIMO_PROF){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO_PROF);
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
        validacaoSalarioProfessor(salario);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Disciplina: %s |Salário: %.2f",disciplina,salario);
    }
}
