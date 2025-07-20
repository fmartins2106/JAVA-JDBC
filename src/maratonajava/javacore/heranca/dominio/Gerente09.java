package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente09 extends Funcionario09{
    private String cargoGestao;
    private double salario;

    public Gerente09(String nome, String departamento, int idade, String cargoGestao, double salario) {
        super(nome, departamento, idade);
        this.cargoGestao = cargoGestao;
        this.salario = salario;
    }

    public static final String MENSAGEM_ERRO_CARGO_GESTAO = "Campo cargo de gestão não pode ser vazio ou conter caracteres.";
    public static final double MENOR_SALARIO_GESTAO = 5000;
    public static final String MENSAGEM_ERRO_SALARIO_GESTAO = "Salário não pode ser menor que R$5.000";

    private void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGO_GESTAO);
        }
    }

    private void validacaoSalario(double salario){
        if (salario < MENOR_SALARIO_GESTAO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO_GESTAO);
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
        validacaoCargoGestao(cargoGestao);
        this.salario = salario;
    }

    public static String validandoCargoGestao(Scanner scanner){
        while (true){
            String cargoGestao = "";
            System.out.print("Cargo de gestão:");
            cargoGestao = scanner.nextLine().trim();
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERRO_CARGO_GESTAO);
                continue;
            }
            return formatoNome(cargoGestao);
        }
    }
    public static double validandoSalarioGestao(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario <MENOR_SALARIO_GESTAO){
                    System.out.println(MENSAGEM_ERRO_SALARIO_GESTAO);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Gerente09 validacaoDadosGestao(Scanner scanner,String nome, String departamento, int idade){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalarioGestao(scanner);
        return new Gerente09(nome,departamento,idade,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
