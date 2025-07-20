package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente19 extends Funcionario19{
    private String cargo;
    private double salario;

    public Assistente19(String nome, String cpf, int idade, String departamento, String cargo, double salario) {
        super(nome, cpf, idade, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_GERAL = 2000;

    public static void validacaoCargo(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagemValidacaoFuncionario19.ERRO_CARGO_GERAL.getDescricao());
        }
    }

    public static void validacaoSalarioGeral(double salario){
        if (salario < SALARIO_MINIMO_GERAL){
            throw new IllegalArgumentException(MensagemValidacaoFuncionario19.ERRO_SALARIO_GERAL.getDescricaoFormatada(SALARIO_MINIMO_GERAL));
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
                return formatoNome(cargo);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
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
                System.out.println("Salário inválido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Assistente19 validandoDadosCargoGeral(Scanner scanner,String nome, String cpf, int idade, String departamento){
        String cargo = validandoCargoGeral(scanner);
        double salario = validandoSalarioGeral(scanner);

        return new Assistente19(nome,cpf,idade,departamento,cargo,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }
}
