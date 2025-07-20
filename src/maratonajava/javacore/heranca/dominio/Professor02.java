package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor02 extends Pessoa02{
    private String disciplina;
    private double salario;

    public Professor02(String nome, int idade, String cpf, String disciplina, double salario) {
        super(nome, idade, cpf);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final String MENSAGEM_VALIDANDO_DISCIPLINA = "Campo não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_SALARIO_MINIMO_PROFESSOR = "Salário de professor não pode ser menor que R$5.000";
    public static final double SALARIO_MINIMO_PROFESSOR = 5000;

    private void validandoString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_VALIDANDO_DISCIPLINA);
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        validandoString(disciplina);
        this.disciplina = Pessoa02.formatoNome(disciplina);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MENSAGEM_SALARIO_MINIMO_PROFESSOR);
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|Disciplina: "+disciplina+" |Salário: "+salario);
    }
}
