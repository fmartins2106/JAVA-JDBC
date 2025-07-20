package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.heranca.test.Funcionario05;

import java.util.Scanner;

public class Assistente05 extends Funcionario05 {
    private int horasTrabalhadas;
    private double salario;

    public Assistente05(String nome, String departamento, int idade, int horasTrabalhadas, double salario) {
        super(nome, departamento, idade);
        setHorasTrabalhadas(horasTrabalhadas);
        setSalario(salario);
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public static final String MENSAGEM_HORAS_MINIMO = "Horas trabalhadas não pode ser menor que zero.";
    public static final int HORAS_MINIMA = 0;
    public void setHorasTrabalhadas(int horasTrabalhadas) {
        if (horasTrabalhadas < HORAS_MINIMA){
            System.out.println(MENSAGEM_HORAS_MINIMO);
        }
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getSalario() {
        return salario;
    }

    public static final String MENSAGEM_SALARIO_MINIMO = "Salário de assistente não pode ser menor que R$2.000";
    public static final double SALARIO_ASSISTENTE =2000;
    public void setSalario(double salario) {
        if (salario < SALARIO_ASSISTENTE){
            throw new IllegalArgumentException(MENSAGEM_SALARIO_MINIMO);
        }
        this.salario = salario;
    }
    public static Assistente05 validandoAssistente(Scanner scanner,String nome, String departamento, int idade ){
        int horasTrabalhada =0;
        while (true){
            try {
                System.out.print("Horas trabalhadas:");
                horasTrabalhada = Integer.parseInt(scanner.nextLine());
                if (horasTrabalhada < HORAS_MINIMA){
                    System.out.println(MENSAGEM_HORAS_MINIMO);
                }else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        double salario=0;
        while (true){
            try {
                System.out.print("Salário:R$");
                salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_ASSISTENTE){
                    System.out.println(MENSAGEM_SALARIO_MINIMO);
                }else {
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new Assistente05(nome,departamento,idade,horasTrabalhada,salario);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Horas trabalhada: "+horasTrabalhadas+" |Salário:R$ "+salario);
    }
}
