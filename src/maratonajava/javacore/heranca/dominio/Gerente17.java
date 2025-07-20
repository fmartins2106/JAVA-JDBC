package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente17 extends Funcionario17{
    private String cargoGestao;
    private double salario;

    public Gerente17(String nome, String cpf, int idade, String departamento, String cargoGestao, double salario) {
        super(nome, cpf, idade, departamento);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final double SALARIO_GESTAO = 3500;

    private void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario17.ERRO_CARGO_GESTAO.getDescricao());
        }
    }

    private void validacaoSalarioGestao(double salario){
        if (salario < SALARIO_GESTAO){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario17.ERRO_SALARIO_GESTAO.getDescricao());
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
            System.out.print("Cargo gestão:");
            String cargoGestao = scanner.nextLine().trim();
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)}*$")){
                System.out.println(MensagensValidacaoFuncionario17.ERRO_CARGO_GESTAO.getDescricao());
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
                if (salario < SALARIO_GESTAO){
                    System.out.println(MensagensValidacaoFuncionario17.ERRO_SALARIO_GESTAO.getDescricao());
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static Gerente17 validandoDadosGestao(Scanner scanner,String nome, String cpf, int idade, String departamento){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalarioGestao(scanner);

        return new Gerente17(nome,cpf,idade,departamento,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
