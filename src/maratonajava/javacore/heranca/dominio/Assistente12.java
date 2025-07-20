package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class Assistente12 extends Funcionario12 {
    private String cargo;
    private double salario;

    public Assistente12(String nome, int idade, String cpf, String departamento, String cargo, double salario) {
        super(nome, idade, cpf, departamento);
        setCargo(cargo);
        setSalario(salario);
    }

    public static final String MENSAGEM_ERRO_CARGO = "Campo cargo não pode ser vazio ou conter caracteres.";
    public static final double SALARIO_MINIMO_CARGOS = 2000;
    public static final String MENSAGEM_ERRO_SALARIOS_CARGOS = "Salário não pode ser menor que R$2.000";

    public void validacaoCargo(String cargo){
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CARGO);
        }
    }

    public void validacaoSalario(double salario){
        if (salario < SALARIO_MINIMO_CARGOS){
            throw new IllegalArgumentException(MENSAGEM_ERRO_SALARIOS_CARGOS);
        }
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        validacaoCargo(cargo);
        this.cargo = formatoNome(cargo);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        validacaoSalario(salario);
        this.salario = salario;
    }

    public static String validandoCargo(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println(MENSAGEM_ERRO_CARGO);
                continue;
            }
            return cargo;
        }
    }

    public static double validandoSalarioGeral(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < SALARIO_MINIMO_CARGOS){
                    System.out.println(MENSAGEM_ERRO_SALARIOS_CARGOS);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Assistente12 validandoDadosCargos(Scanner scanner,String nome, int idade, String cpf, String departamento){
        String cargo = validandoCargo(scanner);
        double salario = validandoSalarioGeral(scanner);
        return new Assistente12(nome,idade,cpf,departamento,cargo,salario);
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Cargo: %s |Salário:R$ %.2f",cargo,salario);
    }
}
