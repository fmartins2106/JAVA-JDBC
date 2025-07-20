package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.time.Year;

public class Livro09 {
    private String titulo;
    private String autor;
    private int ano;
    private String categoria;

    public Livro09(String titulo, String autor, int ano, String categoria){
        setTitulo(titulo);
        setAutor(autor);
        setAno(ano);
        setCategoria(categoria);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty() || !titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo titulo não pode conter caracteres ou esta vazio.");
        }
        this.titulo = formatoNome(titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{all}]+)+$")){
            throw new IllegalArgumentException("Campo autor precisa ter nome complet, não ser vazio e não conter caracteres.");
        }
        this.autor = formatoNome(autor);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoAtual = Year.now().getValue();
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
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    @Override
    public String toString() {
        return String.format("Título: %s |Autor: %s |Ano: %s |Categoria: %s",titulo,autor,ano,categoria);
    }
}
