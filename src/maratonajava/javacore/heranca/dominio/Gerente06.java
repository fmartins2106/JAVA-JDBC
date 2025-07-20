package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente06 extends Funcionario06 {
    private String cargoGestao;
    private double salario;

    public Gerente06(String nome, String departamento, int idade, String cargoGestao, double salario) {
        super(nome, departamento, idade);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final String MENSAGEM_CARGO_GESTAO = "Campo não pode ser vazio ou conter caracteres;";
    public static final String MENSAGEM_SALARIO_GESTAO = "Salário de cargo de gestão não pode ser menor que R$5.000";
    public static final double SALARIO_CARGO_GESTAO = 5000;

    private void validandoFormatoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_CARGO_GESTAO);
        }
    }

    public static boolean validacaoFormatoCargoGestao(String cargoGestao){
        if ( cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(MENSAGEM_CARGO_GESTAO);
            return false;
        }
        return true;
    }

    public String getCargoGestao() {
        return cargoGestao;
    }

    public void setCargoGestao(String cargoGestao) {
        validandoFormatoCargoGestao(cargoGestao);
        this.cargoGestao = formatoNome(cargoGestao);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < SALARIO_CARGO_GESTAO){
            throw new IllegalArgumentException(MENSAGEM_SALARIO_GESTAO);
        }
        this.salario = salario;
    }

    public static Gerente06 validandoDadosGerencia(Scanner scanner, String nome, String departamento, int idade ){
        String cargoGestao="";
        while (true){
            System.out.print("Cargo gestão:");
            cargoGestao = scanner.nextLine().trim();
            if (validacaoFormatoCargoGestao(cargoGestao)){
                Funcionario06.formatoNome(cargoGestao);
                break;
            }
        }
        double salario = 0;
        while (true){
            try {
                System.out.print("Salário:R$");
                salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_CARGO_GESTAO){
                    System.out.println(MENSAGEM_SALARIO_GESTAO);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new Gerente06(nome,departamento,idade,cargoGestao,salario);
    }


    @Override
    public String toString() {
        return super.toString()+String.format("|Cargo gestão: "+cargoGestao+" |Salário:R$ "+salario);
    }
}