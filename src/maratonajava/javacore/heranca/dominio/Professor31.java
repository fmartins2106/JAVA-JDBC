package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Professor31 extends Pessoa31{
    private String disciplina;
    private double salario;

    public Professor31(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoProfessor31.DISCIPLINA.getDescricao());
        }
    }

    private static final double SALARIO_MINIMO = 3500;

    public static void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoProfessor31.SALARIO.getDescricaoFormatada(SALARIO_MINIMO));
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

    public enum MensagensValidacaoProfessor31{
        DISCIPLINA("Campo disciplina não pode ser vazio ou conter caracteres."),
        SALARIO("Salário não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoProfessor31(String descricao) {
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
