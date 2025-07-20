package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente11 extends Funcionario11{
    private String cargoGestao;
    private double salario;

    public Gerente11(String nome, String departamento, int idade, String cargoGestao, double salario) {
        super(nome, departamento, idade);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_CARGO_GESTAO = "Campo cargo gestão não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_SALARIO_GESTAO = "Salário não pode ser menor que R$3.500";
    public static final double SALARIO_CARGO_GESTAO = 3500;

    private void validacaoCargoGesta0(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGO_GESTAO);
        }
    }

    private void validacaoSalarioProfessor(double salario){
        if (salario < SALARIO_CARGO_GESTAO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO_GESTAO);
        }
    }

    public String getCargoGestao() {
        return cargoGestao;
    }

    public void setCargoGestao(String cargoGestao) {
        validacaoCargoGesta0(cargoGestao);
        this.cargoGestao = formatoNome(cargoGestao);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalarioProfessor(salario);
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
            return cargoGestao;
        }
    }

    public static double validandoSalarioProfessor(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_CARGO_GESTAO){
                    System.out.println(MENSAGEM_ERRO_CARGO_GESTAO);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Gerente11 validandoDadosGestao(Scanner scanner,String nome, String departamento, int idade ){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalarioProfessor(scanner);
        return new Gerente11(nome,departamento,idade,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
