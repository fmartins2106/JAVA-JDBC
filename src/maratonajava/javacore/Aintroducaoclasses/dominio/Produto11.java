package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Produto11 implements Cloneable{
    private String nome;
    private double valor;
    private String categoria;

    public Produto11(String nome, double valor, String categoria){
        setNome(nome);
        setValor(valor);
        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo nome não pode ser vazio ou conter caracteres. Digite o nome completo.");
        }
        this.nome = formatoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0 || valor > 10000){
            throw new IllegalArgumentException("Valor não pode ser menor que zero e maior que R$10.000,00");
        }
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo categoria não pode ficar vazio ou conter caracteres.");
        }
        this.categoria = formatoNome(categoria);
    }

    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatandoNome = new StringBuilder();
        for (String palavra : palavras){
            formatandoNome.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return formatandoNome.toString().trim();
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo nome não pode ser vazio ou conter caracteres. Digite o seu nome completo.");
            }else {
                return formatoNome(nome);
            }
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0 || valor > 10000){
                    System.out.println("Vamos precisa ser maior que zero e menor que R$10.000");
                }else {
                    return valor;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode estar vazio ou conter caracteres.");
            }else {
                return formatoNome(categoria);
            }
        }
    }
    public void tabelaProdutos(int index, int produto11s){
        if (index == 0){
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-20s\n","No","Nome","Valor","Categoria");
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-8.2f %-20s\n",index,getNome(),getValor(),getCategoria());
        if (index == produto11s-1){
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
    @Override
    public Produto11 clone(){
        try {
            return (Produto11) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("Erro na clonagem.");
        }
    }

}
