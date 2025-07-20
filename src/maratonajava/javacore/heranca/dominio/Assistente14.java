package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente14 extends Funcionario14{
    private String cargo;
    private double salario;

    public Assistente14(String nome, int idade, String cpf, String departamento, String cargo, double salario) {
        super(nome, idade, cpf, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_GERAL = 2000;

    private void validacaoCargo(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensDeValidacao.ERRO_CARGO_GERAL.getDescricao());
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_GERAL){
            throw new IllegalArgumentException(MensagensDeValidacao.ERRO_SALARIO_GERAL.getDescricao());
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
                System.out.println(MensagensDeValidacao.ERRO_CARGO_GERAL.getDescricao());
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
                if (salario < SALARIO_MINIMO_GERAL){
                    System.out.println(MensagensDeValidacao.ERRO_CARGO_GERAL.getDescricao());
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente14 validandoDadoCargoGeral(Scanner scanner,String nome, int idade, String cpf, String departamento){
        String cargo = validandoCargo(scanner);
        double salario = validandoSalario(scanner);
        return new Assistente14(nome,idade,cpf,departamento,cargo,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }
}
