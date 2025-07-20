package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente18 extends Funcionario18{
    private String cargoGestao;
    private double salario;

    public Gerente18(String nome, String cpf, int idade, String departamento, String cargoGestao, double salario) {
        super(nome, cpf, idade, departamento);
        this.cargoGestao = cargoGestao;
        this.salario = salario;
    }

    public static final double SALARIO_MINIMO_PROF = 3500;

    private static void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario18.ERRO_CARGO_GESTAO.getDescricao());
        }
    }

    private static void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_PROF){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario18.ERRO_SALARIO_PROF.getDescricao());
        }
    }


    public String getCargoGestao() {
        return cargoGestao;
    }

    public void setCargoGestao(String cargoGestao) {
        validacaoCargoGestao(cargoGestao);
        this.cargoGestao = formatoNome(cargoGestao);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    public static String validandoCargoGestao(Scanner scanner){
        while (true){
            System.out.print("Cargo gestão:");
            String cargoGestao = scanner.nextLine().trim();
            try {
                validacaoCargoGestao(cargoGestao);
                return cargoGestao;
            }catch (IllegalArgumentException e){
                System.out.println(MensagensValidacaoFuncionario18.ERRO_CARGO_GESTAO.getDescricao());
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
                System.out.println(MensagensValidacaoFuncionario18.ERRO_SALARIO_PROF2.getDescricao());
            }catch (IllegalArgumentException e){
                System.out.println(MensagensValidacaoFuncionario18.ERRO_SALARIO_PROF.getDescricao());
            }
        }
    }

    public static Gerente18 validandoDadosGerente(Scanner scanner, String nome, String cpf, int idade, String departamento){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalario(scanner);

        return new Gerente18(nome,cpf,idade,departamento,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
