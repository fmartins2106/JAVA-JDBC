package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Assistente01 extends Funcionario01{
    private int horasDeTrabalho;
    private double salario;

    public Assistente01(String nome, int idade, String departamento, int horasDeTrabalho, double salario) {
        super(nome, idade, departamento);
        setHorasDeTrabalho(horasDeTrabalho);
        setSalario(salario);
    }

    public int getHorasDeTrabalho() {
        return horasDeTrabalho;
    }

    public void setHorasDeTrabalho(int horasDeTrabalho) {
        if (horasDeTrabalho < 0){
            throw new IllegalArgumentException("Horas trabalhasdas não pode ser menor que zero.");
        }
        this.horasDeTrabalho = horasDeTrabalho;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 2000){
            throw new IllegalArgumentException("Salário de assistente não pode ser menor que R$2.000,00");
        }
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Horas de trabalho: "+horasDeTrabalho+ "|Salário:R$ "+salario);
    }
}
