package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente12 extends Funcionario12 {
    private String cargoGestao;
    private double salario;

    public Gerente12(String nome, int idade, String cpf, String departamento, String cargoGestao, double salario) {
        super(nome, idade, cpf, departamento);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_CARGO_GESTAO = "Campo cargo gestão não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_SALARIO_GESTAO = "Salário não pode ser menor que R$4.000";
    public static final double SALARIO_GESTAO = 4000;

    private void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGO_GESTAO);
        }
    }

    private void validacaoSalarioGestao(double salario){
        if (salario < SALARIO_GESTAO){
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
        validacaoSalarioGestao(salario);
        this.salario = salario;
    }

    public static String validandoCargoGestao(Scanner scanner){
        while (true){
            System.out.print("Digite o nome:");
            String cargoGestao = scanner.nextLine().trim();
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERRO_CARGO_GESTAO);
                continue;
            }
            return cargoGestao;
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_GESTAO){
                    System.out.println(MENSAGEM_ERRO_SALARIO_GESTAO);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Gerente12 cadastrandoDadosGestao(Scanner scanner,String nome, int idade, String cpf, String departamento){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalario(scanner);
        return new Gerente12(nome,idade,cpf,departamento,cargoGestao,salario);
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
