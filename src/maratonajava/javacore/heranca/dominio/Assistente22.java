package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Arrays;
import java.util.Scanner;

public class Assistente22 extends Funcionario22{
    private String cargoGeral;
    private double salario;

    public Assistente22(String nome, String cpf, int idade, String departamento, String cargoGeral, double salario) {
        super(nome, cpf, idade, departamento);
        setCargoGeral(cargoGeral);
        setSalario(salario);
    }

    public static void validacaoCargoGeral(String cargoGeral){
        if (cargoGeral == null || cargoGeral.isEmpty() || !cargoGeral.matches("\\p{L}+( \\p{L}+)*$")){
            throw new IllegalArgumentException(Gerente22.MensagensValidacaoGestao22.CARGO.getDescricao());
        }
    }

    private static final double SALARIO_MINIMO_GERAL = 2000;

    public static void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_GERAL){
            throw new IllegalArgumentException(MensagensValidacaoAssistente22.SALARIO.getDescricaoFormatada(SALARIO_MINIMO_GERAL));
        }
    }

    public String getCargoGeral() {
        return cargoGeral;
    }

    public void setCargoGeral(String cargoGeral) {
        validacaoCargoGeral(cargoGeral);
        this.cargoGeral = formatoNome(cargoGeral);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    public static String validandoCargoGeral(Scanner scanner){
        while (true){
            try {
                System.out.print("Cargo:");
                String cargo = scanner.nextLine().trim();
                Assistente22.validacaoCargoGeral(cargo);
                return Assistente22.formatoNome(cargo);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalarioGeral(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                Assistente22.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para salário.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Assistente22 validandoDadosAssistente(Scanner scanner, String nome, String cpf, int idade, String departamento){
        String cargo = validandoCargoGeral(scanner);
        double salario = validandoSalarioGeral(scanner);

        return new Assistente22(nome,cpf,idade,departamento,cargo,salario);
    }

    public enum MensagensValidacaoAssistente22{
        CARGO("Campo cargo não pode ser vazio ou conter caracteres."),
        SALARIO("Salário não pode ser menor que %.2f.");

        private final String descricao;

        MensagensValidacaoAssistente22(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Cargo: %s |Salário:R$ %.2f",cargoGeral,salario);
    }
}
