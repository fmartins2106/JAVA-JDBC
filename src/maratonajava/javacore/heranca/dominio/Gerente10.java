package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente10 extends Funcionario10{
    private String cargoGestao;
    private double salario;

    public Gerente10(String nome, int idade, String departamento, String cargoGestao, double salario) {
        super(nome, idade, departamento);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_CARGO_GESTAO = "Campo cargo gestão não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_SALARIO = "Campo salário não pode ser vazio ou conter caracteres.";
    public static final double SALARIO_MINIMO_GESTAO = 5000;

    private void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGO_GESTAO);
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_GESTAO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO);
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
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERRO_CARGO_GESTAO);
                continue;
            }
            return formatoNome(cargoGestao);
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario <SALARIO_MINIMO_GESTAO){
                    System.out.println(MENSAGEM_ERRO_SALARIO);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Gerente10 validandoDadosGestao(Scanner scanner,String nome, int idade, String departamento ){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalario(scanner);
        return new Gerente10(nome,idade,departamento,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo Gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
