package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente16 extends Funcionario16{
    private String cargoGestao;
    private double salario;

    public Gerente16(String nome, String cpf, int idade, String departamento, String cargoGestao, double salario) {
        super(nome, cpf, idade, departamento);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }
    public static final double SALARIO_MINIMO_GESTAO = 3500;

    private void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensErro16.ERRO_CARGO_GESTAO.getDescricao());
        }
    }

    private void validacaoSalarioGestao(double salario){
        if (salario < SALARIO_MINIMO_GESTAO){
            throw new IllegalArgumentException(MensagensErro16.ERRO_SALARIO_GESTAO.getDescricao());
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
        String cargoGestao = "";
        while (true){
            System.out.print("Cargo gestão:");
            cargoGestao = scanner.nextLine();
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MensagensErro16.ERRO_CARGO_GESTAO.getDescricao());
                continue;
            }
            return formatoNome(cargoGestao);
        }
    }

    public static double validandoSalarioGestao(Scanner scanner){
        double salarioGestao = 0;
        while (true){
            try {
                System.out.print("Salário:R$");
                salarioGestao = Double.parseDouble(scanner.nextLine());
                if (salarioGestao < SALARIO_MINIMO_GESTAO){
                    System.out.println(MensagensErro16.ERRO_SALARIO_GESTAO.getDescricao());
                    continue;
                }
                return salarioGestao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Gerente16 validandoDadosGerencia(Scanner scanner,String nome, String cpf, int idade, String departamento){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalarioGestao(scanner);
        return new Gerente16(nome,cpf,idade,departamento,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
