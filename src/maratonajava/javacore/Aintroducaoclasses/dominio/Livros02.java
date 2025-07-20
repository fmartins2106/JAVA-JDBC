package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.sql.SQLOutput;

public class Livros02 {
    private String titulo;
    private String autor;
    private int ano;
    private double preco;

    public Livros02(String titulo, String autor, int ano, double preco){
        setTitulo(titulo);
        setAutor(autor);
        setAno(ano);
        setPreco(preco);
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        if (titulo==null || titulo.isEmpty() || !titulo.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Digite um valor válido.");
        }else {
            this.titulo = formantandoNomeLivros(titulo);
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor ==null || autor.isEmpty() || !autor.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
            throw new IllegalArgumentException("Digite o nome completo do autor, tente novamente.");
        }else {
            this.autor = formantandoNomeLivros(autor);
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoAtual = java.time.Year.now().getValue();
        if (ano <=1800 || ano>=anoAtual){
            throw new IllegalArgumentException("Digite um valor válido. Tente novamente.");
        }else {
            this.ano = ano;
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco<=0){
            throw new IllegalArgumentException("ERRO. Tente novamente, preço precisa ser maior que 0.");
        }
        this.preco = preco;
    }

    public void monstrandoDadosLivros(){
        System.out.println("Nome:"+getTitulo());
        System.out.println("Autor:"+getAutor());
        System.out.println("Ano:"+getAno());
        System.out.println("Preço:"+String.format("%.2f",getPreco()));
        System.out.println("__________________________________________________________");
    }

    private static String formantandoNomeLivros(String titulo){
        String[] palavras = titulo.toLowerCase().split("\\s+");
        StringBuilder tituloFormatado = new StringBuilder();
        for (String palavra : palavras){
            tituloFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return tituloFormatado.toString().trim();
    }
}

