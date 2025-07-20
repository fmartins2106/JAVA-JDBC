package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente16 extends Funcionario16 {
    private String cargoGeral;
    private double salario;

    public Assistente16(String nome, String cpf, int idade, String departamento, String cargoGeral, double salario) {
        super(nome, cpf, idade, departamento);
        this.cargoGeral = cargoGeral;
        this.salario = salario;
    }

    public static final double SALARIO_GERAL = 2000;

    private void validacaoCargoGeral(String cargoGeral){
        if (cargoGeral == null || cargoGeral.isEmpty() || !cargoGeral.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(Funcionario16.MensagensErro16.ERRO_CARGO_GERAL.getDescricao());
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_GERAL){
            throw new IllegalArgumentException(Funcionario16.MensagensErro16.ERRO_SALARIO_GERAL.getDescricao());
        }
    }

    public String getCargoGeral() {
        return cargoGeral;
    }

    public void setCargoGeral(String cargoGeral) {
        validacaoCargoGeral(cargoGeral);
        this.cargoGeral = cargoGeral;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    public static String validandoCargoGeral(Scanner scanner){
        String cargo = "";
        while (true){
            System.out.print("Cargo:");
            cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(Funcionario16.MensagensErro16.ERRO_CARGO_GERAL.getDescricao());
                continue;
            }
            return Funcionario16.formatoNome(cargo);
        }
    }

    public static double validandoSalarioGeral(Scanner scanner){
        double salario = 0;
        while (true){
            try {
                System.out.print("Salário:R$");
                salario = Double.parseDouble(scanner.nextLine());
                    if (salario < SALARIO_GERAL){
                        System.out.println(Funcionario16.MensagensErro16.ERRO_SALARIO_GERAL.getDescricao());
                        continue;
                    }
                    return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente16 validadosAssistente(Scanner scanner, String nome, String cpf, int idade, String departamento){
        String cargo = validandoCargoGeral(scanner);
        double salario =validandoSalarioGeral(scanner);

        return new Assistente16(nome,cpf,idade,departamento,cargo,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f", cargoGeral,salario);
    }
}
