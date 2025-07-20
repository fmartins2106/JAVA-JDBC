package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Funcionario07 {
    private String nome;
    private double salario;
    private String cargo;

    public Funcionario07(String nome, double salario, String cargo){
        setNome(nome);
        setSalario(salario);
        setCargo(cargo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite uma opção válida. Tente novamente.");
        }
        this.nome = formatoNome(nome);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario<1510){
            throw new IllegalArgumentException("Salário não pode ser menor que salário mìnimo. Tente novamente.");
        }
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Digite um valor válido.");
        }
        this.cargo = formatoNome(cargo);
    }

    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
    public static String verificandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Digite um nome válido. Tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("ERRO, digite um nome válido.");
                }else{
                    return formatoNome(nome);
                }
            }
        }
    }
    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario<1510){
                    System.out.println("Salário não pode ser menor que salário mínimo. Tente novamente.");
                }else {
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static String validandoCargo(Scanner scanner){
        while (true){
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty()){
                System.out.println("Cargo não pode ficar vazio. Tente novamente.");
            }else {
                if (!cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("ERRO. Digite um valor válido.");
                }else {
                    return formatoNome(cargo);
                }
            }
        }
    }

    public void exbindoRelatorioFuncionarios(int index, int funcionario07s){
        if (index==0){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-15s %-15s\n","No","Nome","Salário","Cargo");
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s R$%-13.2f %-20s\n",index,getNome(),getSalario(),getCargo());
        if (index == funcionario07s-1){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }


    }



}
