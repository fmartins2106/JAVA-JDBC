package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;

public class Professor25 extends Pessoa25{
    private String disciplina;
    private double salario;

    public Professor25(String nome, String cpf, int idade, String disciplina, double salario) {
        super(nome, cpf, idade);
        setDisciplina(disciplina);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_PROFESSOR = 3500;

    public static void validacaoDisiciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoProfessor25.ERRO_DISCIPLINA.getDescricao());
        }
    }

    public static void validacaoSalarioProfessor(double salario){
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MensagensValidacaoProfessor25.ERRO_SALARIO_PROFESSOR.getDescricaoFormatada(SALARIO_MINIMO_PROFESSOR));
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        validacaoDisiciplina(disciplina);
        this.disciplina = formatoString(disciplina);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalarioProfessor(salario);
        this.salario = salario;
    }

    public enum MensagensValidacaoProfessor25{
        ERRO_DISCIPLINA("Campo disciplina não pode ser vazio ou conter caracteres."),
        ERRO_SALARIO_PROFESSOR("Salário de professor não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoProfessor25(String descricao){
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
    public String toString(){
        return super.toString()+String.format("|Disciplina: %s |Salário:R$%.2f",disciplina,salario);
    }
}
