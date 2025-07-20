package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente14 extends Funcionario14{
    private String cargoGestao;
    private double salario;

    public Gerente14(String nome, int idade, String cpf, String departamento, String cargoGestao, double salario) {
        super(nome, idade, cpf, departamento);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_GESTAO = 4000;

    private void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensDeValidacao.ERRO_CARGO_GESTAO.getDescricao());
        }
    }

    private void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_GESTAO){
            throw new IllegalArgumentException(MensagensDeValidacao.ERRO_SALARIO_GESTAO.getDescricao());
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
            String cargoGestao = scanner.nextLine();
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MensagensDeValidacao.ERRO_CARGO_GESTAO.getDescricao());
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
                if (salario < SALARIO_MINIMO_GESTAO){
                    System.out.println(MensagensDeValidacao.ERRO_SALARIO_GESTAO.getDescricao());
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Gerente14 validandoDadosGerencia(Scanner scanner,String nome, int idade, String cpf, String departamento ){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalarioGestao(scanner);
        return new Gerente14(nome,idade,cpf,departamento,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
