package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente07 extends Funcionario07{
    private int horasTrabalhadas;
    private double salario;

    public Assistente07(String nome, String departamento, int idade, int horasTrabalhadas, double salario) {
        super(nome, departamento, idade);
        this.horasTrabalhadas = horasTrabalhadas;
        this.salario = salario;
    }

    public static final String MENSAGEM_HORAS_MINIMAS = "Horas trabalhadas não pode ser menor que zero.";
    public static final int MINIMO_HORAS_TRABALHADAS = 0;
    public static final double SALARIO_MINIMO_ASSISTENTE = 2000;
    public static final String MENSAGEM_SALARIO_MINIMO_ASSISTENTE = "Salário de assistente não pode ser menor que R$2.000";

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        if (horasTrabalhadas < MINIMO_HORAS_TRABALHADAS){
            throw new IllegalArgumentException(MENSAGEM_HORAS_MINIMAS);
        }
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO_ASSISTENTE){
            throw new IllegalArgumentException(MENSAGEM_SALARIO_MINIMO_ASSISTENTE);
        }
        this.salario = salario;
    }

    public static Assistente07 validandoDadosAssistente(Scanner scanner, String nome, String departamento, int idade){
        int horasTrabalhadas=0;
        while (true){
            try {
                System.out.print("Horas trabalhadas:");
                horasTrabalhadas = Integer.parseInt(scanner.nextLine());
                if (horasTrabalhadas < MINIMO_HORAS_TRABALHADAS){
                    System.out.println(MENSAGEM_HORAS_MINIMAS);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        double salario = 0;
        while (true){
            try {
                System.out.print("Salário:R$");
                salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_MINIMO_ASSISTENTE){
                    System.out.println(MENSAGEM_SALARIO_MINIMO_ASSISTENTE);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new Assistente07(nome,departamento,idade,horasTrabalhadas,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|Horas trabalhadas: "+horasTrabalhadas+" |Salário:R$ "+salario);
    }
}
