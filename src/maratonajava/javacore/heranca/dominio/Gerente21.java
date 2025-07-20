package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente21 extends Funcionario21{
    private String cargoGestao;
    private double salario;

    public Gerente21(String nome, String cpf, int idade, String departamento, String cargoGestao, double salario) {
        super(nome, cpf, idade, departamento);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_GESTAO = 3500;

    public static void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario21.ERRO_CARGO_GESTAO.getDescricao());
        }
    }

    public static void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_GESTAO){
            throw new IllegalArgumentException(MensagensValidacaoFuncionario21.ERRO_SALARIO_GESTAO.getDescricaoFormatada(SALARIO_MINIMO_GESTAO));
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
            try {
                System.out.print("Cargo gestão:");
                String cargoGestao = scanner.nextLine().trim();
                validacaoCargoGestao(cargoGestao);
                return formatoNome(cargoGestao);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalarioGestao(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para salário.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Gerente21 validandoDadosGerencia(Scanner scanner,String nome, String cpf, int idade, String departamento){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalarioGestao(scanner);

        return new Gerente21(nome,cpf,idade,departamento,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
