package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Livro05 {
    private String titulo;
    private String autor;
    private double valor;
    private int quantidade;

    public Livro05(String titulo,String autor, double valor, int quantidade){
        setTitulo(titulo);
        setAutor(autor);
        setValor(valor);
        setQuantidade(quantidade);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty() || !titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo título não pode ser nulo, vazio ou conter caracteres, tente novamente.");
        }
        this.titulo = formantandoNome(titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty() || !autor.matches("^[\\p{L}+( [\\p{L}])+]+$")){
            throw new IllegalArgumentException("Nome não pode ser nulo, vázio, ou ter nome incompleto, tente novamente.");
        }
        this.autor = formantandoNome(autor);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor<0 || valor>10000){
            throw new IllegalArgumentException("Valor não pode ser menor que zero ou maior que R$10.000. Tente novamente.");
        }
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade<0){
            throw new IllegalArgumentException("Quantidade não pode ser menor que zero. Tente novamente.");
        }
        this.quantidade = quantidade;
    }
    public static double valorDoLivro(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o valor do livro:");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor<0 || valor>10000){
                    System.out.println("Vamos precisa ser maior que zero e menor que R$10.000. Tente novamente.");
                }else {
                    return valor;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido. Tente novamente.");
            }
        }
    }
    public static int quantidadeDeLivros(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade<0){
                    System.out.println("ERRO. Quantidade não pode ser menor que zero. Tente novamente.");
                }else {
                    return quantidade;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite um valor válido, tente novamente.");
            }
        }
    }

    public void exibindoResultadosLivros(int index, int Livro05s){
        if (index==0){
            for (int n=0;n<80;n++){
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-25s %-8s %-8s\n","No","Título","Autor","Valor","Quantidade");
            for (int n=0;n<80;n++){
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s %-25s R$%-8.2f %-8d\n",index,getTitulo(),getAutor(),getValor(),getQuantidade());
        if (index == Livro05s-1){
            for (int n=0;n<80;n++){
                System.out.print("=");
            }
            System.out.println();
        }

    }

    private static String formantandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado =new StringBuilder();
        for (String palavra : palavras ){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
