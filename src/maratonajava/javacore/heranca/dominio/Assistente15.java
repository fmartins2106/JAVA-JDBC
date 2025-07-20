package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente15 extends Funcionario15{
    private String cargo;
    private double salario;

    public Assistente15(String nome, int idade, String cpf, String departamento, String cargo, double salario) {
        super(nome, idade, cpf, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_GERAL = 2000;

    public void validacaoCargo(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensEValidacao.ERRO_CARGO_GERAL.getDescricao());
        }
    }

    public void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_GERAL){
            System.out.println(MensagensEValidacao.ERRO_SALARIO_GERAL.getDescricao());
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

    public static String validandoCargoGeral(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MensagensEValidacao.ERRO_SALARIO_GERAL.getDescricao());
                continue;
            }
            return formatoNome(cargo);
        }
    }

    public static double validandoSalarioGeral(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_MINIMO_GERAL){
                    System.out.println(MensagensEValidacao.ERRO_SALARIO_GERAL.getDescricao());
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente15 validandoDadosCargoGeral(Scanner scanner,String nome, int idade, String cpf, String departamento ){
        String cargo = validandoCargoGeral(scanner);
        double salario = validandoSalarioGeral(scanner);
        return new Assistente15(nome,idade,cpf,departamento,cargo,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }
}
