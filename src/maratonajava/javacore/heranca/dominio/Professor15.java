package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor15 extends Pessoa15{
    private String disciplina;
    private double salario;

    public Professor15(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final double SALARIO_PROFESSOR = 3500;

    private void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(ErroPrevisto.ERRO_DISCIPLINA.getDescricao());
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_PROFESSOR){
            throw new IllegalArgumentException(ErroPrevisto.ERRO_SALARIO_PROF.getDescricao());
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
