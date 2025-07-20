package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente02 extends Funcionario02{
    private int horasTrabalhada;
    private double salario;

    public Assistente02(String nome, String departamento, int idade, int horasTrabalhada, double salario) {
        super(nome, departamento, idade);
        setHorasTrabalhada(horasTrabalhada);
        setSalario(salario);
    }

    public int getHorasTrabalhada() {
        return horasTrabalhada;
    }

    private static final int MINIMO_HORAS =0;
    public void setHorasTrabalhada(int horasTrabalhada) {
        if (horasTrabalhada < MINIMO_HORAS){
            throw new IllegalArgumentException("horas trabalhadas não pode ser menor que 0.");
        }
        this.horasTrabalhada = horasTrabalhada;
    }

    public double getSalario() {
        return salario;
    }

    private static final double SALARIO_MINIMO =2000;
    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO){
           throw new IllegalArgumentException("Salário não pode ser menor que R$2.000");
        }
        this.salario = salario;
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Horas trabalhadas: "+horasTrabalhada+" |Salário:R$ "+salario);
    }


}
