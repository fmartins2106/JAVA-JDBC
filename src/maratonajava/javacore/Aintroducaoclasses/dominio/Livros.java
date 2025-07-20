package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

public class Livros {
    public String titulo;
    public String autor;
    public int ano;

    public Livros(String titulo, String autor, int ano){
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;

    }
    public void exibirDetalhes(){
        System.out.println("titulo:"+titulo);
        System.out.println("Autor:"+autor);
        System.out.println("Ano:"+ano);
        System.out.println("___________________________________");
    }


}
