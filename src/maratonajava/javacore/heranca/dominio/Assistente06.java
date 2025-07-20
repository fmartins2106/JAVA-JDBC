package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente06 extends Funcionario06{
    private int horasTrabalhada;
    private double salario;

    public Assistente06(String nome, String departamento, int idade, int horasTrabalhada, double salario) {
        super(nome, departamento, idade);
        setHorasTrabalhada(horasTrabalhada);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_ASSISTENTE = 2000;
    public static final String MENSAGEM_SALARIIO_MINIMO_ASSISTENTE = "Salário de assistente não pode ser menor que R$2.000";
    public static final int MINIMO_HORAS_TRABALHADAS = 0;
    public static final String MENSAGEM_MINIMO_HORAS_TRAB = "Hora não pode ser negativa.0";



    public int getHorasTrabalhada() {
        return horasTrabalhada;
    }

    public void setHorasTrabalhada(int horasTrabalhada) {
        if (horasTrabalhada < MINIMO_HORAS_TRABALHADAS){
            throw new IllegalArgumentException(MENSAGEM_MINIMO_HORAS_TRAB);
        }
        this.horasTrabalhada = horasTrabalhada;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO_ASSISTENTE){
            throw new IllegalArgumentException(MENSAGEM_SALARIIO_MINIMO_ASSISTENTE);
        }
        this.salario = salario;
    }

    public static Assistente06 validandoDadosAssistente(Scanner scanner,String nome, String departamento, int idade ){
        int horasTrabalhada = 0;
        while (true){
            try {
                System.out.print("Horas Trabalhada:");
                horasTrabalhada = Integer.parseInt(scanner.nextLine());
                if (horasTrabalhada < MINIMO_HORAS_TRABALHADAS){
                    System.out.println(MENSAGEM_MINIMO_HORAS_TRAB);
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
                    System.out.println(MENSAGEM_SALARIIO_MINIMO_ASSISTENTE);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new Assistente06(nome,departamento,idade,horasTrabalhada,salario);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Horas Trabalhada: "+horasTrabalhada+" |Salário:R$ "+salario);
    }
}
