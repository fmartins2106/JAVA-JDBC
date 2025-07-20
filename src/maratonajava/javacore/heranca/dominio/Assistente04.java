package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Assistente04 extends Funcionario04{
    private int horasTrabalhada;
    private double salario;

    public Assistente04(String nome, String departamento, int idade, int horasTrabalhada, double salario) {
        super(nome, departamento, idade);
        setHorasTrabalhada(horasTrabalhada);
        setSalario(salario);
    }

    public int getHorasTrabalhada() {
        return horasTrabalhada;
    }

    public static final int HORAS_MINIMAS = 0;
    public void setHorasTrabalhada(int horasTrabalhada) {
        if (horasTrabalhada < HORAS_MINIMAS){
            System.out.println("Horas não pode ser menor que zero.");
        }
        this.horasTrabalhada = horasTrabalhada;
    }

    public double getSalario() {
        return salario;
    }

    public static final double SALARIO_ASSISTENTE= 2000;
    public void setSalario(double salario) {
        if (salario < SALARIO_ASSISTENTE){
            throw new IllegalArgumentException("Salário de assistente não pode ser menor que R$2.000");
        }
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Horas trabalhada: "+horasTrabalhada+" |Salário:R$ "+salario);
    }
}
