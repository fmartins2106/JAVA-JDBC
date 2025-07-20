package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor24 extends Pessoa24{
    private String disciplina;
    private double salario;

    public Professor24(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoPessoa24.ERRO_DISCIPLINA.getDescricao());
        }
    }

    public static final double SALARIO_MINIMO_PROFESSOR = 3500;

    public static void validacaoSalarioProfessor(double salario){
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MensagensValidacaoPessoa24.ERRO_SALARIO.getDescricaoFormatada(SALARIO_MINIMO_PROFESSOR));
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
        return super.toString()+String.format(" Disciplina: %s |Salário:R$ %.2f",disciplina,salario);
    }
}
