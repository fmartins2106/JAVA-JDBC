package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Professor30 extends Pessoa30{
    private String disciplina;
    private double salario;

    public Professor30(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoProfessor30.DISCIPLINA.getDescricao());
        }
    }

    private static final double MENOR_SALARIO_PROFESSOR = 3500;

    public static void validacaoSalario(double salario){
        if (salario < MENOR_SALARIO_PROFESSOR){
            throw new IllegalArgumentException(MensagensValidacaoProfessor30.SALARIO.getDescricaoFormatada(MENOR_SALARIO_PROFESSOR));
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

    public enum MensagensValidacaoProfessor30{
        DISCIPLINA("Campo disciplina não pode ser vazio ou conter caracteres."),
        SALARIO("Salário não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoProfessor30(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Disciplina: %s |Salário:R$%.2f",disciplina,salario);
    }
}
