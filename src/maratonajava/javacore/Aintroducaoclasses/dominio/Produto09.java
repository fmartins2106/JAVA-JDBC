package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;


public class Produto09 implements Cloneable{
    private String nome;
    private double valor;
    private String categoria;

    public Produto09(String nome, double valor, String categoria){
        setNome(nome);
        setValor(valor);
        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome==null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Campo nome não pode ser vazio ou ter nome incompleto. Tente novamente.");
        }
        this.nome = formatoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <0 || valor > 10000){
            throw new IllegalArgumentException("Valor não pode ser menor que 0 ou maior que R$10000");
        }
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria==null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo categoria não pode ser vazio ou conter caracteres. Tente novamente.");
        }
        this.categoria = formatoNome(categoria);
    }

    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo nome não pode ser vazio, ter caracteres ou nome incompleto. Tente novamente.");
            }else {
                return formatoNome(nome);
            }
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor<0 || valor >10000){
                    System.out.println("Valor não pode ser menor que zer e maior que R$ 10.000,00");
                }else {
                    return valor;
                }
            }catch (NumberFormatException erro){
                System.out.print("Digite um valor válido. Tente novamente.");
            }
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String cateoria = scanner.nextLine().trim();
            if (cateoria.isEmpty() || !cateoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode ser vazio ou conter caracteres. Tente novamente.");
            }else {
                return formatoNome(cateoria);
            }
        }
    }

    public void exibindoTabelaProdutos(int index, int produto09s){
        if (index==0){
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-16s %-25s\n","No","Nome","Valor","Categoria");
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s R$%-16.2f %-25s\n",index,getNome(),getValor(),getCategoria());
        if (index == produto09s-1){
            for (int i = 0; i < 60; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    @Override
    public Produto09 clone(){
        try {
            return (Produto09) super.clone();
        }catch (CloneNotSupportedException erro){
            throw new AssertionError("ERRO NA CLONAGEM.");
        }
    }

}
