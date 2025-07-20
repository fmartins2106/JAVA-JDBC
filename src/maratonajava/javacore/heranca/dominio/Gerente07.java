package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Gerente07 extends Funcionario07{
    private String cargoGestao;
    private double salario;

    public Gerente07(String nome, String departamento, int idade, String cargoGestao, double salario) {
        super(nome, departamento, idade);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_CARGOS_GESTAO= "Campo cargo gestão não pode ser vazio ou conter caracteres.";
    public static final double SALARIO_MINIMO_GESTAO = 5000;
    public static final String MENSAGEM_ERRO_SALARIO_GESTAO = "Salário nã pode ser menor que R$5.000";

    public void validandoFormatoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGOS_GESTAO);
        }
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
        if (salario < SALARIO_MINIMO_GESTAO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIO_GESTAO);
        }
        this.salario = salario;
    }

    public static Gerente07 validandoCargoGestao(Scanner scanner,String nome, String departamento, int idade){
        String cargoGestao="";
        while (true){
            System.out.print("Cargo gestão:");
            cargoGestao = scanner.nextLine().trim();
            if (cargoGestao.isEmpty() || !cargoGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERRO_CARGOS_GESTAO);
                continue;
            }
            break;
        }
        double salario=0;
        while (true){
            try {
                System.out.print("Salário:R$");
                salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_MINIMO_GESTAO){
                    System.out.println(MENSAGEM_ERRO_SALARIO_GESTAO);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new Gerente07(nome,departamento,idade,cargoGestao,salario);
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|Cargo gestão: "+cargoGestao+" |Salário:R$"+salario);
    }
}
