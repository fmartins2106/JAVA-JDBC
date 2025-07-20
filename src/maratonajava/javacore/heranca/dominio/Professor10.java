package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor10 extends Pessoa10{
    private String disciplina;
    private double salario;

    public Professor10(String nome, int idade, String cpf, String disciplina, double salario) {
        super(nome, idade, cpf);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    public static final String MENSAGEM_ERRO_DISCIPLINA = "Campo disciplina não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERR0_SALARIO = "Salário não pode ser menor que R$3.500,00";
    public static final double SALARIO_MINIMO_PROF = 3500;

    private void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_DISCIPLINA);
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_PROF){
            throw new IllegalArgumentException(MENSAGEM_ERR0_SALARIO);
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
