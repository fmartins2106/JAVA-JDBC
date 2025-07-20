package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import java.util.Scanner;

public class Produto10 implements Cloneable{
    private String nome;
    private double valor;
    private String categoria;

    public Produto10(String nome, double valor, String categoria){
        setNome(nome);
        setValor(valor);
        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Campo nome não pode ficar vazio, nome incompleto ou conter caracteres");
        }
        this.nome = formatoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor<0 || valor>10000){
            throw new IllegalArgumentException("Valor precisa ser maior que zero e menor que R$10.00,00");
        }
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Campo categoria não pode ficar vazio ou conter caracteres. Tente novamente.");
        }
        this.categoria = categoria;
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
                System.out.println("Campo nome não pode ser vazio, somente o primeiro nome ou conter caracteres. Tente novamente.");
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
                if (valor<0 || valor>10000){
                    System.out.println("Valor inválido. Digite um valor entre 0 e R$10.000,00");
                }else {
                    return valor;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO. Tente novamente.");
            }
        }
    }

    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode ficar vazio o ter caracteres. Tente novamente.");
            }else {
                return formatoNome(categoria);
            }
        }
    }

    public void tabelaProdutosCadastrados(int index, int produto10s){
        if (index==0){
            for (int i = 0; i < 85; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-20s %-25s\n","No","Nome","Valor","Categoria");
            for (int i = 0; i < 85; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s R$%-20.2f %-25s\n",index,getNome(),getValor(),getCategoria());
        if (index==produto10s-1){
            for (int i = 0; i < 85; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    @Override
    public Produto10 clone(){
        try {
            return (Produto10) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("Falha na clonagem.");
        }
    }
}
