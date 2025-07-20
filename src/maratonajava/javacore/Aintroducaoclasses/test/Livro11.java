package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import java.util.Arrays;

public class Livro11 {
    private String titulo;
    private String autor;
    private int ano;
    private String categoria;

    public Livro11(String titulo, String autor, int ano, String categoria){
        setTitulo(titulo);
        setAutor(autor);
        setAno(ano);
        setCategoria(categoria);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty() || !titulo.matches("^[\\p{L}\\p{N} ]+$")){
            throw new IllegalArgumentException("Não deixa campo título vazio ou com caracteres.");
        }
        this.titulo = formatoNome(titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Digite nome completo sem adição de caracteres.");
        }
        this.autor = formatoNome(autor);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoAtual = java.time.Year.now().getValue();
        if (ano < 1500 || ano > anoAtual){
            throw new IllegalArgumentException("Ano não pode ser menor que 1500 ou maior que ano atual.");
        }
        this.ano = ano;
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

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
