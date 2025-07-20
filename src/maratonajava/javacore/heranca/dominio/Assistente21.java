package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente21 extends Funcionario21{
    private String cargo;
    private double salario;

    public Assistente21(String nome, String cpf, int idade, String departamento, String cargo, double salario) {
        super(nome, cpf, idade, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final double SALARIO_GERAL = 2000;

    public static void validacaoCargo(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario21.ERRO_CARGO_GESTAO.getDescricao());
        }
    }

    public static void validacaoSalario(double salario){
        if (salario < SALARIO_GERAL){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario21.ERRO_SALARIO_GESTAO.getDescricaoFormatada(SALARIO_GERAL));
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
            try {
                System.out.print("Cargo:");
                String cargo = scanner.nextLine().trim();
                validacaoCargo(cargo);
                return formatoNome(cargo);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para o salário.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Assistente21 validandoDadosAssistente(Scanner scanner, String nome, String cpf, int idade, String departamento){
        String cargo = validandoCargo(scanner);
        double salario = validandoSalario(scanner);

        return new Assistente21(nome,cpf,idade,departamento,cargo,salario);
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }
}
