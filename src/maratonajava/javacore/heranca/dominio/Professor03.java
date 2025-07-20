package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor03 extends Pessoa03 {
    private String disciplina;
    private double salario;

    public Professor03(String nome, int idade, String cpf, String disciplina, double salario) {
        super(nome, idade, cpf);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_DISCIPLINA = "Campo disciplina não pode ser vazio ou conter caracteres. Digite nome completo.";
    public static final String MENSAGEM_SALARIO_MINIMO_PROFESSOR = "Salário não pode ser menor que R$3000.";
    public static final double  SALARIO_MINIMO_PROFESSOR = 3000;

    private void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_DISCIPLINA);
        }
    }

    private void validacaoSalarioProfessor(double salario){
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MENSAGEM_SALARIO_MINIMO_PROFESSOR);
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
    public String toString(){
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$ %.2f",disciplina,salario);
    }
}
