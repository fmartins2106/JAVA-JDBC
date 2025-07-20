package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor22 extends Pessoa22{
    private String disciplina;
    private double salario;

    public Professor22(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_PROF = 3500;

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoPessoa22.ERRO_DISCIPLINA.getDescricao());
        }
    }

    public static void validacaoSalarioProfessor(double salario){
        if (salario < SALARIO_MINIMO_PROF){
            throw new IllegalArgumentException(MensagensValidacaoPessoa22.ERRO_SALARIO_PROF.getDescricaoFormatada(SALARIO_MINIMO_PROF));
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
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$%.2f",disciplina,salario);
    }
}
