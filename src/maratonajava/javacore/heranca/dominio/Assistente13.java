package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente13 extends Funcionario13{
    private String cargo;
    private double salario;

    public Assistente13(String nome, String cpf, int idade, String departamento, String cargo, double salario) {
        super(nome, cpf, idade, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERR0_CARGO = "Campo cargo não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_SALARIO = "Salário não pode ser menor que R$2000";
    public static final double SALARIO_MINIMO_GERAL = 2000;

    public void validacaoCargoGeral(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERR0_CARGO);
        }
    }

    public void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_GERAL){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO);
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
        validacaoSalario(salario);
        this.salario = salario;
    }

    public static String validandoCargo(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERR0_CARGO);
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
                    System.out.println(MENSAGEM_ERRO_SALARIO);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente13 validacaoDadosGeral(Scanner scanner,String nome, String cpf, int idade, String departamento){
        String cargo = validandoCargo(scanner);
        double salario = validandoSalario(scanner);
        return new Assistente13(nome,cpf,idade,departamento,cargo,salario);
    }


    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }
}
