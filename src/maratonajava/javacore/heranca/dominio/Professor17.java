package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor17 extends Pessoa17{
    private String disciplina;
    private double salario;

    public Professor17(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    public static final double SALARIO_MINIMO_PROFESSOR = 3500;

    private void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensErroPessoa17.ERRO_DISCIPLINA.getDescricao());
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MensagensErroPessoa17.ERRO_SALARIO.getDescricao());
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
