package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.text.NumberFormat;
import java.util.Scanner;

public class Assistente17 extends Funcionario17{
    private String cargo;
    private double salario;

    public Assistente17(String nome, String cpf, int idade, String departamento, String cargo, double salario) {
        super(nome, cpf, idade, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_GERAL = 2000;

    private void validacaoCargoGeral(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario17.ERRO_CARGO_GERAL.getDescricao());
        }
    }

    public void validacaoSalarioGeral(double salario){
        if (salario < SALARIO_MINIMO_GERAL){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario17.ERRO_SALARIO_GERAL.getDescricao());
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        validacaoCargoGeral(cargo);
        this.cargo = formatoNome(cargo);
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
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MensagensValidacaoFuncionario17.ERRO_CARGO_GERAL);
                continue;
            }
            return formatoNome(cargo);
        }
    }

    public static double validandoSalarioGeral(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_MINIMO_GERAL){
                    System.out.println(MensagensValidacaoFuncionario17.ERRO_SALARIO_GERAL.getDescricao());
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente17 validandoDadosGeral(Scanner scanner, String nome, String cpf, int idade, String departamento){
        String cargo = validandoCargoGeral(scanner);
        double salario = validandoSalarioGeral(scanner);

        return new Assistente17(nome,cpf,idade,departamento,cargo,salario);
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }

}
