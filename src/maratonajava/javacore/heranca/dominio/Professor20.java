package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor20 extends Pessoa20{
    private String disciplina;
    private double salario;

    public Professor20(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_PROF = 3500;

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoPessoa20.ERRO_DISCIPLINA.getDescricao());
        }
    }

    public static void validacaoSalarioProf(double salario){
        if (salario < SALARIO_MINIMO_PROF){
            System.out.println();
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
        validacaoSalarioProf(salario);
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$ %.2f",disciplina,salario);
    }
}

