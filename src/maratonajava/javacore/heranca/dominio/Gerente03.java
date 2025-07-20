package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente03 extends Funcionario03{
    private String cargoGestao;
    private double salario;

    public Gerente03(String nome, String departamento, int idade, String cargoGestao, double salario) {
        super(nome, departamento, idade);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public String getCargoGestao() {
        return cargoGestao;
    }

    public void setCargoGestao(String cargoGestao) {
        validandoString(cargoGestao);
        this.cargoGestao = formatoNome(cargoGestao);
    }

    public double getSalario() {
        return salario;
    }

    private static double SALARIO_MINIMO=5000;
    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO){
            throw new IllegalArgumentException("Salário mínimo não pode ser menor que R$5.000,00");
        }
        this.salario = salario;
    }



    @Override
    public String toString(){
        return super.toString()+String.format("Cargo gestão: "+cargoGestao+ "| Salário:R$ "+salario);
    }





}
