package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Professor26 extends Pessoa26{
    private String disciplina;
    private double salario;

    public Professor26(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static void validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoProfessor26.DISCIPLINA.getDescricao());
        }
    }

    public static final double SALARIO_MINIMO_PROFESSOR = 3500;

    public static void validacaoSalarioProfessor(double salario){
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MensagensValidacaoProfessor26.SALARIO.getDescricaoFormatada(SALARIO_MINIMO_PROFESSOR));
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

    public enum MensagensValidacaoProfessor26{
        DISCIPLINA("Campo disciplina não pode ser vazio ou conter caracteres."),
        SALARIO("Salário não pode ser menor que %.2f.");

        public final String descricao;

        MensagensValidacaoProfessor26(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Disciplina: %s |Salário:%.2f ",disciplina,salario);
    }
}
