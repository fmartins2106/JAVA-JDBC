package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente11 extends Funcionario11{
    private String cargo;
    private double salario;

    public Assistente11(String nome, String departamento, int idade, String cargo, double salario) {
        super(nome, departamento, idade);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_CARGO = "Campo cargo não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_SALARIO = "Salário não pode ser menor que R$2.000";
    public static final double SALARIO_GERAL = 2.000;

    private void validacaoCargo(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGO);
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_GERAL){
            System.out.println(MENSAGEM_ERRO_SALARIO);
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        validacaoCargo(cargo);
        this.cargo = formatoNome(cargo);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    public static String validandoCargo(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERRO_CARGO);
                continue;
            }
            return formatoNome(cargo);
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_GERAL){
                    System.out.println(MENSAGEM_ERRO_SALARIO);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static Assistente11 cadastroAssistente(Scanner scanner, String nome, String departamento, int idade){
        String cargo = validandoCargo(scanner);
        double salario = validandoSalario(scanner);
        return new Assistente11(nome,departamento,idade,cargo,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f ",cargo,salario);
    }
}
