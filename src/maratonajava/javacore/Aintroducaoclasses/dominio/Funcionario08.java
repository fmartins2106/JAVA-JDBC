package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Funcionario08 implements Cloneable{
    private String nome;
    private double salario;
    private String cargo;

    public Funcionario08(String nome, double salario, String cargo){
        setNome(nome);
        setSalario(salario);
        setCargo(cargo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo nome não pode ser vazio ou conter caracteres. Digite seu nome completo. Tente novamente.");
        }
        this.nome = formatoNome(nome);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario<1510){
            throw new IllegalArgumentException("Salário não pode ser menor que salário mínimo.");
        }
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo==null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo cargo não pode ser vazio ou conter caracteres.");
        }
        this.cargo = formatoNome(cargo);
    }
    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatandoNome = new StringBuilder();
        for (String palavra : palavras){
            formatandoNome.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return formatandoNome.toString().trim();
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo nome não pode ser vazio ou conter caracteres. Digite seu nome completo.");
            }else {
                return formatoNome(nome);
            }
        }
    }
    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario<1510){
                    System.out.println("Salário deve ser maior que salário mínimo. Tente novamente.");
                }else {
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
    }
    public static String validandoCargo(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo cargo não pode se vázio ou conter caracteres.");
            }else {
                return formatoNome(cargo);
            }
        }
    }
    public void exibindoListaFuncionarios(int index, int funcionario08s){
        if (index==0){
            for (int i = 0; i < 65; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-12s %-20s\n","No","Nome","Salário","Cargo");
            for (int i = 0; i < 65; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s R$%-8.2f %-20s\n",index,getNome(),getSalario(),getCargo());
        if (index==funcionario08s-1){
            for (int i = 0; i < 65; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
    @Override
    public Funcionario08 clone(){
        try {
            return (Funcionario08) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("ERRO. Clonagem não realizada.");
        }
    }


}
