package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente18 extends Funcionario18{
    private String cargo;
    private double salario;

    public Assistente18(String nome, String cpf, int idade, String departamento, String cargo, double salario) {
        super(nome, cpf, idade, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final double SALARIO_GERAL = 2000;

    private static void validacaoCargo(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario18.ERRO_CARGO_GERAL.getDescricao());
        }
    }

    private static void validacaoSalarioGeral(double salario){
        if (salario < SALARIO_GERAL){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario18.ERRO_SALARIO_GERAL.getDescricao());
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
        validacaoSalarioGeral(salario);
        this.salario = salario;
    }

    public static String validandoCargoGeral(Scanner scanner){
        while (true){
            try {
                System.out.print("Cargo:");
                String cargo = scanner.nextLine().trim();
                validacaoCargo(cargo);
                return cargo;
            }catch (IllegalArgumentException e){
                System.out.println(MensagensValidacaoFuncionario18.ERRO_CARGO_GERAL.getDescricao());
            }
        }
    }

    public static double validandoSalarioGeral(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                validacaoSalarioGeral(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println(MensagensValidacaoFuncionario18.ERRO_SALARIO_GERAL.getDescricao());
            }catch (IllegalArgumentException e){
                System.out.println(MensagensValidacaoFuncionario18.ERRO_SALARIO_GERAL2.getDescricao());
            }
        }
    }

    public static Assistente18 validandoDadosAssistente(Scanner scanner,String nome, String cpf, int idade, String departamento){
        String cargo = validandoCargoGeral(scanner);
        double salario = validandoSalarioGeral(scanner);

        return new Assistente18(nome,cpf,idade,departamento,cargo,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }
}
