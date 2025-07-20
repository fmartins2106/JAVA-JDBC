package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.time.Year;


public class Livro07 {
    private String titulo;
    private String autor;
    private int ano;
    private String categoria;

    public Livro07(String titulo, String autor, int ano, String categoria){
        setTitulo(titulo);
        setAutor(autor);
        setAno(ano);
        setCategoria(categoria);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo==null || titulo.isEmpty() || !titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Campo titulo não pode ser vazio ou conter caracteres.");
        }
        this.titulo = formatoNomes(titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor==null || autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Campo autor não pode ser vazio, conter caracteres. Digite o nome completo.");
        }
        this.autor = formatoNomes(autor);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        int anoAtual = Year.now().getValue();
        if (ano<1500 || ano> anoAtual){
            throw new IllegalArgumentException("Ano não pode ser menor que 1500 ou maior que ano atual.");
        }
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. Campo não pode ficar vazio ou conter caracteres.");
        }
        this.categoria = formatoNomes(categoria);
    }

    public static String formatoNomes(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatarPalavra = new StringBuilder();
        for (String palavra : palavras){
            formatarPalavra.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return formatarPalavra.toString().trim();
    }

    @Override
    public String toString(){
        return String.format("Título: %s | Autor: %s | Ano: %d | Categoria: %s",titulo,autor,ano,categoria);
    }

}

