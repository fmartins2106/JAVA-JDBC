package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente09 extends Funcionario09{
    private String cargoGeral;
    private double salario;

    public Assistente09(String nome, String departamento, int idade, String cargoGeral, double salario) {
        super(nome, departamento, idade);
        this.cargoGeral = cargoGeral;
        this.salario = salario;
    }
    public static final String MENSAGEM_ERRO_CARGOS = "Campo cargo não pode ser vazio ou conter caracteres.";
    public static final double SALARIO_MINIMO_CARGOS = 2000;
    public static final String MENSAGEM_ERRO_SALARIO_MIN = "Campo salário mínimo não pode ser menor que R2.000";

    private void validacaoCargos(String cargoGeral){
        if (cargoGeral == null || cargoGeral.isEmpty() || !cargoGeral.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGOS);
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_CARGOS){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO_MIN);
        }
    }

    public String getCargoGeral() {
        return cargoGeral;
    }

    public void setCargoGeral(String cargoGeral) {
        validacaoCargos(cargoGeral);
        this.cargoGeral = formatoNome(cargoGeral);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    public static String validacaoCargo(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERRO_CARGOS);
                continue;
            }
            return cargo;
        }
    }

    public static double vvalidacaoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario <SALARIO_MINIMO_CARGOS){
                    System.out.println(MENSAGEM_ERRO_SALARIO_MIN);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente09 validandoDadosAssistente(Scanner scanner, String nome, String departamento, int idade){
        String cargoGeral = validacaoCargo(scanner);
        double salario = vvalidacaoSalario(scanner);
        return new Assistente09(nome,departamento,idade,cargoGeral,salario);
    }


    @Override
    public String toString() {
        return super.toString()+String.format("Cargo: %s |Salário:R$ %.2f",cargoGeral,salario);
    }
}



