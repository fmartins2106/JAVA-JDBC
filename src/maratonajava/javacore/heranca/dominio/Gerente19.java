package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente19 extends Funcionario19{
    private String cargoGestao;
    private double salario;

    public Gerente19(String nome, String cpf, int idade, String deparatamento, String cargoGestao, double salario) {
        super(nome, cpf, idade, deparatamento);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final double SALARIO_MINIMO_CARGO_GESTAO = 3500;

    public static void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagemValidacaoFuncionario19.ERRO_CARGO_GESTAO.getDescricao());
        }
    }

    public static void validacaoSalarioGestao(double salario){
        if (salario < SALARIO_MINIMO_CARGO_GESTAO){
            throw new IllegalArgumentException(MensagemValidacaoFuncionario19.ERRO_SALARIO_GESTAO.getDescricaoFormatada(SALARIO_MINIMO_CARGO_GESTAO));
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
            try {
                System.out.print("Cargo gestão:");
                String cargoGestao = scanner.nextLine().trim();
                validacaoCargoGestao(cargoGestao);
                return cargoGestao;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalarioCargoGestao(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                validacaoSalarioGestao(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para salário.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Gerente19 validandoDadosGerencia(Scanner scanner,String nome, String cpf, int idade, String deparatamento ){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalarioCargoGestao(scanner);

        return new Gerente19(nome,cpf,idade,deparatamento,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}

