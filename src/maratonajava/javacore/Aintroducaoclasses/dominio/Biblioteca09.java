package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca09 {
    private ArrayList<Livro09> livro09s;

    public Biblioteca09(){
        this.livro09s = new ArrayList<>();
    }

    public void addLivros(Livro09 livro){
        livro09s.add(livro);
    }

    public void listaLivros(){
        if (livro09s.isEmpty()){
            System.out.println("Lista vazia, cadastre livros.");
        }else {
            livro09s.forEach(livro-> System.out.println(livro));
        }
    }

    public void pesquisaAutor(String autor){
        boolean encontrado = false;
        for (Livro09 livro09 : livro09s){
            if (livro09.getAutor().equalsIgnoreCase(autor)){
                System.out.println(livro09);
                encontrado =true;
            }
        }
        if (!encontrado){
            System.out.println("Livro não encontrado.");
        }
    }

    public void alterarDadosLivro(Scanner scanner, int indice){
        if (indice < 0 || indice>= livro09s.size()){
            System.out.println("Livro não encontrado.");
        }else {
            Livro09 livro09 = livro09s.get(indice);
            livro09.setTitulo(Biblioteca09.validandoTitulo(scanner));
            livro09.setAutor(Biblioteca09.validandoAutor(scanner));
            livro09.setAno(Biblioteca09.validandoAno(scanner));
            livro09.setCategoria(Biblioteca09.validandoCategoria(scanner));

        }
    }
    public static String validandoTitulo(Scanner scanner){
        while (true){
            System.out.print("Título:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo titulo não pode ser vazio ou conter caracteres.");
                continue;
            }
            return Livro09.formatoNome(nome);
        }
    }
    public static String validandoAutor(Scanner scanner){
        while (true){
            System.out.print("Autor:");
            String autor = scanner.nextLine().trim();
            if (autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo autor não pode ser vazio ou conter caracteres,precisa ter nome completo.");
                continue;
            }
            return Livro09.formatoNome(autor);
        }
    }
    public static int validandoAno(Scanner scanner){
        int anoAtual = Year.now().getValue();
        while (true){
            try {
                System.out.print("Ano:");
                int ano = Integer.parseInt(scanner.nextLine());
                if (ano <1500 || ano > anoAtual){
                    System.out.println("Ano precisa ser maior que 1500 e menor que ano atual.");
                    continue;
                }
                return ano;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo categoria não pode ser vazio ou conter caracteres.");
                continue;
            }
            return Livro09.formatoNome(categoria);
        }
    }

    public ArrayList<Livro09> getLivro09s() {
        return livro09s;
    }

    public void setLivro09s(ArrayList<Livro09> livro09s) {
        this.livro09s = livro09s;
    }
    public void excluirLivro(Scanner scanner, int indice){
        if (indice >=0 && indice < livro09s.size()){
            livro09s.remove(indice);
        }else {
            System.out.println("Indice não encontrado.Tente novamente.");
        }
    }
}
