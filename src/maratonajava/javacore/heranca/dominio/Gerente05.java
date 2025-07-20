package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.heranca.test.Funcionario05;

import java.util.Scanner;

public class Gerente05 extends Funcionario05 {
    private String cargoGestao;
    private double salario;

    public Gerente05(String nome, String departamento, int idade, String cargoGestao, double salario) {
        super(nome, departamento, idade);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }


    public String getCargoGestao() {
        return cargoGestao;
    }

    public void setCargoGestao(String cargoGestao) {
        validandoCampoComString(cargoGestao);
        this.cargoGestao = Funcionario05.formatoNome(cargoGestao);
    }

    public double getSalario() {
        return salario;
    }

    public static final double SALARIO_MINIMO_GESTAO = 5000;
    public void setSalario(double salario) {
        if (salario < SALARIO_MINIMO_GESTAO){
            throw new IllegalArgumentException("Salário não pode ser menor que "+SALARIO_MINIMO_GESTAO);
        }
        this.salario = salario;
    }

    private static final String MENSANGEM_ERRO = "Campo não pode ser vazio ou conter caracteres.";

    public static Gerente05 validandoDadosCargoGestao(Scanner scanner, String nome, String departamento, int idade ){
        String cargoGestao="";
        while (true){
            System.out.print("Cargo de gestão:");
            cargoGestao = scanner.nextLine().trim();
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println(MENSANGEM_ERRO);
                continue;
            }
            break;
        }
        double salario = 0;
        while (true){
            try {
                System.out.print("Salário:R$");
                salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_MINIMO_GESTAO){
                    System.out.println("Salário não pode ser menor que "+SALARIO_MINIMO_GESTAO);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }

        return new Gerente05(nome,departamento,idade,cargoGestao,salario);
    }


    @Override
    public String toString(){
        return super.toString()+String.format("|Cargo gestão: "+cargoGestao+" |Salário: "+salario);
    }

}
