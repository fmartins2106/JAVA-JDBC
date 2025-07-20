package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente08 extends Funcionario08{
    private String cargoGeral;
    private double salario;

    public Assistente08(String nome, String departamento, int idade, String cargoGeral, double salario) {
        super(nome, departamento, idade);
        setCargoGeral(cargoGeral);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_CARGO_GERAL = "Campo não pode ser vazio ou conter caracteres.";
    public static final String MENSAGE_ERRO_SALARIO_GERAL = "Salário não pode ser menor que R$2.000";
    public static final double MENOR_SALARIO =2000;

    public void validacaoCargoGeral(String cargoGeral){
        if (cargoGeral == null || cargoGeral.isEmpty() || !cargoGeral.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGO_GERAL);
        }
    }

    public void validacaoSalarioGeral(double salario){
        if (salario < MENOR_SALARIO){
            throw new IllegalArgumentException(MENSAGE_ERRO_SALARIO_GERAL);
        }
    }

    public String getCargoGeral() {
        return cargoGeral;
    }

    public void setCargoGeral(String cargoGeral) {
        validacaoCargoGeral(cargoGeral);
        this.cargoGeral = formatoNomes(cargoGeral);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalarioGeral(salario);
        this.salario = salario;
    }

    public static String validandoCargoGeral(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargoGeral = scanner.nextLine().trim();
            if (cargoGeral.isEmpty() || !cargoGeral.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERRO_CARGO_GERAL);
                continue;
            }
            return formatoNomes(cargoGeral);
        }
    }

    public static double validandoSalarioGeral(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < MENOR_SALARIO){
                    System.out.println(MENSAGE_ERRO_SALARIO_GERAL);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente08 validacaoCargoGeral(Scanner scanner,String nome, String departamento, int idade){
        String cargoGeral = Assistente08.validandoCargoGeral(scanner);
        double salario = Assistente08.validandoSalarioGeral(scanner);
        return new Assistente08(nome,departamento,idade,cargoGeral,salario);
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Cargo: "+cargoGeral+" |Salário:R$ "+salario);
    }

}
