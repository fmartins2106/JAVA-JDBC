package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;


import javax.swing.*;
import java.util.*;

public class Produto06 implements Cloneable{
    private String nome;
    private double valor;
    private String categoria;

    public Produto06(String nome, double valor, String categoria){
        setNome(nome);
        setValor(valor);
        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Campo nome não pode ficar vazio ou conter caracteres. Tente novamente. Digite o seu nome completo.");
        }
        this.nome = formatoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if ( valor<0 || valor > 10000){
            throw new IllegalArgumentException("Valor não pode ser menor que zero ou maior que R$10.000,00");
        }
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria==null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Campo categoria não pode ficar vazio ou conter caracteres. Tente novamente.");
        }
        this.categoria = formatoNome(categoria);
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatoNome = new StringBuilder();
        for (String palavra : palavras){
            formatoNome.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return formatoNome.toString().trim();
    }
    public static String verificandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Campo não pode ser vazio. Tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("Digite o nome completo do produto sem caracteres.");
                }else {
                    return formatoNome(nome);
                }
            }
        }
    }
    public static double verificandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor<0 || valor>10000){
                    System.out.println("ERRO. Valor não pode ser menor que zero ou maior que R$10.000");
                }else {
                    return valor;
                }
            }catch (NumberFormatException e){
                System.out.println("Erro:"+e.getMessage());
            }
        }
    }
    public static String verificandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Digite a categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty()){
                System.out.println("Campo categoria não pode ficar vazio. Tente novamente.");
            }else {
                if (!categoria.matches("^[\\p{L}]+([\\p{L}]+)$")){
                    System.out.println("Digite o nome completo sem uso de caracteres.");
                }else {
                    return formatoNome(categoria);
                }
            }
        }
    }
    public  void monstrandoTabelProduto(int index, int produto06s){
        if (index==0){
            for (int n = 0; n < 48; n++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-8s %-15s\n","No","Nome","Valor","Categoria");
            for (int n = 0; n < 48; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s R$%-8.2f %-15s\n",index,getNome(),getValor(),getCategoria());
        if (index == produto06s-1){
            for (int n = 0; n < 48; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    @Override
    public Produto06 clone(){
        try {
            return (Produto06) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonagem não suportada.");
        }
    }

 }
