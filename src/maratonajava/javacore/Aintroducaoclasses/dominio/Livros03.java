package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;


public class Livros03 {
    private String titulo;
    private String autor;
    private double valor;

    public Livros03(String titulo, String autor, double valor){
        setTitulo(titulo);
        setAutor(autor);
        setValor(valor);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo ==null || titulo.isEmpty() || !titulo.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
            throw new IllegalArgumentException("Campo nome não pode ser vazio, nulo ou conter caracteres no nome.  Tente novamente.");
        }
        this.titulo = formatandoNomes(titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor ==null || autor.isEmpty() || !autor.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
            throw new IllegalArgumentException("Campo autor não poder ser vazio, nulo ou conter somente o primeiro nome ou ainda caracteres no nome. Tente novamente.");
        }
        this.autor = formatandoNomes(autor);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor<=0){
            throw new IllegalArgumentException("Valor não pode ser menor ou igual a zero. Tente novamente.");
        }
        this.valor = valor;
    }
    public void descontoLivros(double desconto){
        this.valor-= this.valor*(desconto/100);
    }
    public void mostrarResultadosLivros(){
        System.out.println("Titulo:"+getTitulo());
        System.out.println("Autor:"+getAutor());
        System.out.println("Valor com desconto:"+getValor());
        System.out.println("_____________________________________________________________");
    }

    private static String formatandoNomes(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado =new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
}
