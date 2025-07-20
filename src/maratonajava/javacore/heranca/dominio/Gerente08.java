package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente08 extends Funcionario08{
    private String cargoGestao;
    private double salario;

    public Gerente08(String nome, String departamento, int idade, String cargoGestao, double salario) {
        super(nome, departamento, idade);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final String MENSAGEM_CARGO_GESTAO = "Campo cargo gestão não pode ser vazio ou conter caracteres.";
    public static final double MENOR_SALARIO_GESTAO = 5000;
    public static final String MENSAGEM_ERRO_SALARIO_GESTAO = "Salário não pode ser menor que R$5.000";

    public void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_CARGO_GESTAO);
        }
    }

    public void validacaoSalario(double salario){
        if (salario < MENOR_SALARIO_GESTAO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO_GESTAO);
        }
    }

    public String getCargoGestao() {
        return cargoGestao;
    }

    public void setCargoGestao(String cargoGestao) {
        validacaoCargoGestao(cargoGestao);
        this.cargoGestao = formatoNomes(cargoGestao);
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
            System.out.print("Carto de gestão:");
            String cargoGestao = scanner.nextLine().trim();
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_CARGO_GESTAO);
                continue;
            }
            return formatoNomes(cargoGestao);
        }
    }

    public static double validandoSalarioCargoGestao(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < MENOR_SALARIO_GESTAO) {
                    System.out.println(MENSAGEM_ERRO_SALARIO_GESTAO);
                    continue;
                }
                return salario;
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Gerente08 validandoDadosGerencia(Scanner scanner, String nome, String departamento, int idade){
            String cargoGestao = Gerente08.validandoCargoGestao(scanner);
            double salario = Gerente08.validandoSalarioCargoGestao(scanner);
            return new Gerente08(nome,departamento,idade,cargoGestao,salario);
    }


    @Override
    public String toString(){
        return super.toString()+String.format(" |Cargo gestão: "+cargoGestao+" |Salário:R$ "+salario);
    }
}
