package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Assistente03 extends Funcionario03{
    private int horasTrabalhadas;
    private double salario;

    public Assistente03(String nome, String departamento, int idade, int horasTrabalhadas, double salario) {
        super(nome, departamento, idade);
        setHorasTrabalhadas(horasTrabalhadas);
        setSalario(salario);
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getSalario() {
        return salario;
    }

    private static double SALARIO_MINIMO = 2000;
    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO){
            throw new IllegalArgumentException("Salário não pode ser menor que salário mínimo.");
        }
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format("Horas trabalhada: "+horasTrabalhadas+" |Salário: "+salario);
    }

}
