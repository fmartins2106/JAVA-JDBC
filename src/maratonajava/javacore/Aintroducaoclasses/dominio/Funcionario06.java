package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Funcionario06 {
    private String nome;
    private String cargo;
    private double salario;
    private int experiencia;

    public Funcionario06(String nome, String cargo, double salario, int experiencia){
        setNome(nome);
        setCargo(cargo);
        setSalario(salario);
        setExperiencia(experiencia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome ==null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( \\p{L}+)+$")){
            throw new IllegalArgumentException("ERRO. Digite o nome completo.");
        }
        this.nome = formatoNome(nome);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Campo não pode ficar vazio, tente novamente.");
        }
        this.cargo = formatoNome(cargo);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario<1500){
            throw new IllegalArgumentException("Salário não pode ser menor que salário minimo.");
        }
        this.salario = salario;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        if (experiencia<0){
            throw new IllegalArgumentException("Digite um valor maior que zero.");
        }
        this.experiencia = experiencia;
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Nome não pode ser vazio.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("Digite nome Completo.");
                }else {
                    return nome = formatoNome(nome);
                }
            }
        }
    }
    public static String validandoCargo(Scanner scanner){
        while (true){
            System.out.print("Digite o cargo:");
            String cargo = scanner.nextLine().trim();
            if (cargo.isEmpty()){
                System.out.println("Campo cargo não pode ser vazio. Tente novamente.");
            }else {
                if (!cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("ERRO. Digite cargo sem uso de caracteres. Tente novamente.");
                }else {
                    return formatoNome(cargo);
                }
            }
        }
    }
    public static double verificandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o salário:");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario<1500){
                    System.out.println("Salário não pode ser menor que salário minimo nacional.");
                }else {
                    return salario;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite um valor válido.");
            }
        }
    }
    public static int validandoExperiencia(Scanner scanner){
        while (true){
            try {
                System.out.print("Anos de experiência:");
                int experiencia = Integer.parseInt(scanner.nextLine());
                if (experiencia<0){
                    System.out.println("Campo não pode ser negativo. Tente novamente.");
                }else {
                    return experiencia;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void exibindoResultados(int index, int funcionario06s){
        if (index==0){
            for (int n=0;n<85;n++){
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-25s %-8s %-8s\n","No","Nome","Cargo","Salário","Anos Experiencia");
            for (int n = 0; n < 85; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-25s %-8s %-8s\n",index,getNome(),getCargo(),getSalario(),getExperiencia());
        if (index == funcionario06s-1){
            for (int n = 0; n < 85; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }


    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeValidado = new StringBuilder();
        for (String palavra : palavras){
            nomeValidado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeValidado.toString().trim();
    }
}
