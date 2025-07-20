package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Professor27 extends Pessoa27{
    private String disciplina;
    private double salario;

    public Professor27(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    private static final double SALARIO_MINIMO_PROFESSOR = 3500;

    public static void validancaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoProfessor27.DISCIPLINA.getDescrica());
        }
    }

    public static void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MensagensValidacaoProfessor27.SALARIO.getDescricaoFormatada(SALARIO_MINIMO_PROFESSOR));
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        validancaoDisciplina(disciplina);
        this.disciplina = formatoNome(disciplina);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    public enum MensagensValidacaoProfessor27{
        DISCIPLINA("Campo disciplina não pode ser vazio ou conter caracteres."),
        SALARIO("Salário não pode ser menor que %.2f.");

        private final String descrica;

        MensagensValidacaoProfessor27(String descrica) {
            this.descrica = descrica;
        }

        public String getDescrica() {
            return descrica;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descrica, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$ %.2f",disciplina,salario);
    }
}
