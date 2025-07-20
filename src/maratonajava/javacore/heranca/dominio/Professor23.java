package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor23 extends Pessoa23{
    private String disciplina;
    private double salario;

    public Professor23(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final double MENOR_SALARIO_PROFESSOR = 3500;

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoPessoa23.ERRO_DISCIPLINA.getDescricao());
        }
    }

    public static void validacaoSalario(double salario){
        if (salario < MENOR_SALARIO_PROFESSOR){
            throw new IllegalArgumentException(MensagensValidacaoPessoa23.ERRO_SALARIO_PROFESSOR.getDescricaoFormatada(MENOR_SALARIO_PROFESSOR));
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        validacaoDisciplina(disciplina);
        this.disciplina = formatoString(disciplina);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$ %.2f",disciplina,salario);
    }

}
