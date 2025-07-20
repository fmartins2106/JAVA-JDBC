package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.time.Year;

public class Livro10 {
    private String titulo;
    private String autor;
    private int ano;
    private String categoria;

    public Livro10(String titulo, String autor, int ano, String categoria ){
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
            throw new IllegalArgumentException("Campo título não pode ser vazio ou conter caracteres.");
        }
        this.titulo = formatoNome(titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo autor não pode ser vazio ou conter caracteres.");
        }
        this.autor = formatoNome(autor);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoAtual = Year.now().getValue();
        if (ano < 1500 || ano > anoAtual){
            throw new IllegalArgumentException("Campo ano não pode ser menor que 1500 e maior que ano atual.");
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
        StringBuilder formatandoNome = new StringBuilder();
        for (String palavra : palavras){
            formatandoNome.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return formatandoNome.toString().trim();
    }
    @Override
    public String toString(){
        return String.format("Título: %s |Autor: %s |Ano: %d |Categoria: %s",titulo,autor,ano,categoria);
    }
}
