package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Funcionario05 {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario05(String nome, String cargo, double salario){
        setNome(nome);
        setCargo(cargo);
        setSalario(salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo nome não pode ser vazio.Digite nome completo sem uso de caracteres. Tente novamente.");
        }
        this.nome = formatandoNome(nome);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.isEmpty() || !cargo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo cargo não pode ser vazio. Digite o cargo sem o uso de caracteres. Tente novamente.");
        }
        this.cargo = formatandoNome(cargo);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario<=1499.99){
            throw new IllegalArgumentException("Salário não pode ser menor que salário mínimo. Tente novamente.");
        }
        this.salario = salario;
    }

    public static double validandoSalario(Scanner scanner){
        double salario=0;
        while (true){
            try {
                System.out.print("Digite o salário:R$");
                salario = Double.parseDouble(scanner.nextLine());
                if (salario<=1499.99){
                    System.out.println("Salário não pode ser menor que salário mínimo. tente novamente.");
                }else {
                    return salario;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite um número válido. Tente novamente.");
            }
        }
    }

    public void aumentoSalario(double aumento){
        this.salario+=this.salario*(aumento/100);
    }

    public void exibindoResultados(){
        System.out.println("Nome:"+getNome());
        System.out.println("Cargo:"+getCargo());
        System.out.println("Salário:"+getSalario());
        System.out.println("______________________________");
    }

    private static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
