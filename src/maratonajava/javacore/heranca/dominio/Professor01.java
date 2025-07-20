package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Professor01 extends Pessoa01{
    private String diciplina;
    private double salario;

    public Professor01(String nome, int idade, String cpf, String diciplina, double salario) {
        super(nome, idade, cpf);
        setDiciplina(diciplina);
        setSalario(salario);
    }

    public String getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(String diciplina) {
        if (diciplina == null || diciplina.isEmpty() || !diciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(Pessoa01.MENSAGEM_FORMATO_INVALIDO);
        }
        this.diciplina = Pessoa01.formatoNome(diciplina);
    }

    public double getSalario() {
        return salario;
    }

    public static final double SALARIO_MINIMO_PROFESSOR = 5000;
    public static final String MENSAGEM_SALARIO_MINIMO_PROFESSOR = "Salário de professor não pode ser menor que R$"+SALARIO_MINIMO_PROFESSOR;
    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO_PROFESSOR){
            throw new IllegalArgumentException(MENSAGEM_SALARIO_MINIMO_PROFESSOR);
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString()+" |Diciplina:"+diciplina+ "|Salário:R$"+salario;
    }
}
