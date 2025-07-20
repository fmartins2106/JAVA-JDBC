package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente10 extends Funcionario10{
    private String cargo;
    private double salario;

    public Assistente10(String nome, int idade, String departamento, String cargo, double salario) {
        super(nome, idade, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_CARGO = "Campo cargo não pode ser vazio ou conter caracteres.";
    public static final double MENOR_SALARIO_CARGOS = 2000;
    public static final String MENSAGEM_ERRO_MENOR_SALARIO_CARGOS = "Salário não pode ser menor que R$2.000";

    private void validacaoCargo(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGO);
        }
    }

    private void validacaoSalario(double salario){
        if (salario < MENOR_SALARIO_CARGOS){
            throw new IllegalArgumentException(MENSAGEM_ERRO_MENOR_SALARIO_CARGOS);
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
                if (salario < MENOR_SALARIO_CARGOS){
                    System.out.println(MENSAGEM_ERRO_MENOR_SALARIO_CARGOS);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente10 validandoDadosAssistente(Scanner scanner,String nome, int idade, String departamento ){
        String cargo = validandoCargo(scanner);
        double salario = validandoSalario(scanner);
        return new Assistente10(nome,idade,departamento,cargo,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }
}
