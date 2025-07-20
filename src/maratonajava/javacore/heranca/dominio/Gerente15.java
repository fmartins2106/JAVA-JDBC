package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente15 extends Funcionario15{
    private String cargoGestao;
    private double salario;

    public Gerente15(String nome, int idade, String cpf, String departamento, String cargoGestao, double salario) {
        super(nome, idade, cpf, departamento);
        this.cargoGestao = cargoGestao;
        this.salario = salario;
    }

    public static final double SALARIO_GESTAO = 3500;

    private void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MensagensEValidacao.ERRO_CARGO_GESTAO.getDescricao());
        }
    }

    private void validacaoSalarioGestao(double salario){
        if (salario < SALARIO_GESTAO){
            throw new IllegalArgumentException(MensagensEValidacao.ERRO_SALARIO_GESTAO.getDescricao());
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
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MensagensEValidacao.ERRO_CARGO_GESTAO.getDescricao());
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
                    System.out.println(MensagensEValidacao.ERRO_SALARIO_GESTAO.getDescricao());
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println(MensagensEValidacao.ERRO_SALARIO_GESTAO.getDescricao());
            }
        }
    }

    public static Gerente15 validandoDadosGestao(Scanner scanner,String nome, int idade, String cpf, String departamento ){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalario(scanner);

        return  new Gerente15(nome,idade,cpf,departamento,cargoGestao,salario);
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Cargo gestão: %s |Salário:R$ %.2f",cargoGestao,salario);
    }
}
