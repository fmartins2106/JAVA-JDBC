package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor06 extends Pessoa06{
    private String disciplina;
    private double salario;

    public Professor06(String nome, int idade, String cpf, String disciplina, double salario) {
        super(nome, idade, cpf);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_DISCIPLINA = "Campo disciplina não pode ser vazio ou conter caracteres.";
    public static final double MENOR_SALARIO_PROF = 3000;
    public static final String MENSAGEM_ERRO_SALARIO_PROF = "Salário não pode ser menor que R3.000";

    private void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_DISCIPLINA);
        }
    }

    private void validacaoSalario(double salario){
        if (salario <MENOR_SALARIO_PROF){
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
        validacaoSalario(salario);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$ %.2f",disciplina,salario);
    }
}
