package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.Scanner;

public class Gerente22 extends Funcionario22{
    private String cargoGestao;
    private double salario;

    public Gerente22(String nome, String cpf, int idade, String departamento, String cargoGestao, double salario) {
        super(nome, cpf, idade, departamento);
        setCargoGestao(cargoGestao);
        setSalario(salario);
    }

    public static void validacaoCargoGestao(String cargoGestao){
        if (cargoGestao == null || cargoGestao.isEmpty() || !cargoGestao.matches("\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoGestao22.CARGO.getDescricao());
        }
    }

    private static final double SALARIO_GESTAO = 3500;

    public static void validacaoSalarioGestao(double salario){
        if (salario < SALARIO_GESTAO){
            throw new IllegalArgumentException(MensagensValidacaoGestao22.SALARIO.getDescricaoFormatada(SALARIO_GESTAO));
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
                Gerente22.validacaoCargoGestao(cargoGestao);
                return Gerente22.formatoNome(cargoGestao);
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
                Gerente22.validacaoSalarioGestao(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Gerente22 validandoDadosGerencia(Scanner scanner, String nome, String cpf, int idade, String departamento){
        String cargoGestao = validandoCargoGestao(scanner);
        double salario = validandoSalarioGestao(scanner);

        return new Gerente22(nome,cpf,idade,departamento,cargoGestao,salario);
    }

    public enum MensagensValidacaoGestao22{
        CARGO("Campo cargo não pode ser vazio ou conter caracteres."),
        SALARIO("Salário não pode ser menor que R$%.2f.");

        private final String descricao;

        MensagensValidacaoGestao22(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valore){
            return String.format(descricao, Arrays.stream(valore).boxed().toArray());
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format("Cargo gestão: %s |Salário:R$%.2f",cargoGestao,salario);
    }
}
