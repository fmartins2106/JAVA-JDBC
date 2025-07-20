package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Livro04 {
    private String titulo;
    private String autor;
    private double valor;
    private int quantidade;

    public Livro04(String titulo, String autor, double valor, int quantidade){
        setTitulo(titulo);
        setAutor(autor);
        setValor(valor);
        setQuantidade(quantidade);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty() || !titulo.matches("^[\\p{all}]+( [\\p{all}]+)*$")){
            throw new IllegalArgumentException("Título não pode ficar vazio, ter caracteres ou valor nulo. Tente novamente.");
        }
        this.titulo = verificandoNome(titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if ( autor == null || autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite o nome completo do autor. Campo não pode ficar vázio. Tente novamente.");
        }
        this.autor = verificandoNome(autor);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor<=-1 || valor>=10000){
            throw new IllegalArgumentException("Vamos deve ser igual ou maior que zero e menor que 10.000.");
        }
        this.valor = valor;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade<=-1){
            throw new IllegalArgumentException("Quantidade não pode ser menor que 0. Tente novamente.");
        }
        this.quantidade = quantidade;
    }


    public static double valorValido(Scanner scanner){
        double valor=0;
        while (true){
            try {
                System.out.print("Digite o valor:R$");
                valor = Double.parseDouble(scanner.nextLine());
                if (valor<=-1 || valor>=10000){
                    System.out.println("Valor não pode ser negativo ou maior que 10.000, tente novamente.");
                }else {
                    return valor;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido. Tente novamente.");
            }
        }
    }

    public static int quantidadeValida(Scanner scanner){
        int quantidade=0;
        while (true){
            try {
                System.out.print("Digite a quantidade:");
                quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade<=-1){
                    System.out.println("Valor precisa ser positivo. Tente novamente.");
                }else {
                    return quantidade;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public void exibindoDadosLivros(int index, int livro04s){
        if (index==0){
            for (int n=0;n<80;n++){
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-25s %-8s %-10s\n","No","Título","Autor","Valor","Quantidade");
            for (int n=0;n<80;n++){
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4s %-25s %-25s %-8.2f %-10d\n",index,getTitulo(),getAutor(),getValor(),getQuantidade());
        if (index== livro04s-1){
            for (int n=0;n<80;n++){
                System.out.print("=");
            }
            System.out.println();
        }

    }
    public void excluindoLivro(int index){

    }

    private static String verificandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
