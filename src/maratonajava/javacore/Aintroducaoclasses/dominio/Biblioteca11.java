package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test.Livro11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca11 {
    private List<Livro11> livro11s;

    public Biblioteca11(){
        this.livro11s = new ArrayList<>();
    }

    public void addLivros(Livro11 livro11){
        livro11s.add(livro11);
    }

    public static String validandoTitulo(Scanner scanner){
        while (true){
            System.out.print("Título:");
            String titulo = scanner.nextLine().trim();
            if (titulo.isEmpty() || !titulo.matches("^[\\p{L}\\p{N} ]+$")){
                System.out.println("Campo titulo não pode ficar vazio ou conter caracteres.");
                continue;
            }
            return Livro11.formatoNome(titulo);
        }
    }

    public static String validandoAutor(Scanner scanner){
        while (true){
            System.out.print("Autor:");
            String autor = scanner.nextLine().trim();
            if (autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo autor não pode ser vazio ou conter caracteres. Digite nome completo.");
                continue;
            }
            return Livro11.formatoNome(autor);
        }
    }

    public static int validandoAno(Scanner scanner){
        while (true){
            int anoAtual = java.time.Year.now().getValue();
            try {
                System.out.print("Ano:");
                int ano = Integer.parseInt(scanner.nextLine());
                if (ano <1500 || ano > anoAtual){
                    System.out.println("Ano não pode ser menor que 1500 ou maior que ano atual.");
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
                System.out.println("Campo categoria não pode ficar vazio ou conter caracteres.");
                continue;
            }
            return Livro11.formatoNome(categoria);
        }
    }

    public void listaLivros(Scanner scanner){
        if (livro11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (int i = 0; i < 80; i++) {
                System.out.print("=");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-25s %-8s %-25s\n","No","Título","Autor","Ano","Categoria");
            for (int i = 0; i < 80; i++) {
                System.out.print("=");
            }
            System.out.println();
            int index=0;
            for (Livro11 livro11 : livro11s){
                System.out.printf("%-4d %-25s %-25s %-8d %-25s\n",index++,livro11.getTitulo(),livro11.getAutor(),livro11.getAno(),livro11.getCategoria());
            }
            for (int i = 0; i < 80; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public void alterarDadosLivro(Scanner scanner){
        if (livro11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String autor = validandoAutor(scanner);
            boolean encontrado = false;
            for (Livro11 livro11 : livro11s){
                if (autor.equalsIgnoreCase(livro11.getAutor())){
                    System.out.println("_______________________________________");
                    livro11.setTitulo(validandoTitulo(scanner));
                    livro11.setAutor(validandoAutor(scanner));
                    livro11.setAno(validandoAno(scanner));
                    livro11.setCategoria(validandoCategoria(scanner));
                    System.out.println("_______________________________________");
                    encontrado = true;
                }
            }
            if (!encontrado){
                System.out.println("Autor não encontrado.");
            }
        }
    }

    public void excluirLivro(Scanner scanner){
        if (livro11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite código do livro:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo >= 0 && codigo <= livro11s.size()){
                    Livro11 livro11 = livro11s.get(codigo);
                    livro11s.remove(livro11);
                    System.out.println("Livro excluido com sucesso.");
                }else {
                    System.out.println("Digite um número de matricula válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void pesquisaPorCategoria(Scanner scanner, List<Livro11>livro11s){
        if (livro11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String categoria = validandoCategoria(scanner);
            boolean encontrado = false;
            for (Livro11 livro11 : livro11s){
                if (categoria.equalsIgnoreCase(livro11.getCategoria())){
                    System.out.println("_________________________________________");
                    System.out.println("Título:"+livro11.getTitulo());
                    System.out.println("Autor:"+livro11.getAutor());
                    System.out.println("Ano:"+livro11.getAno());
                    System.out.println("Categoria:"+livro11.getCategoria());
                    System.out.println("_________________________________________ ");
                    encontrado = true;
                }
            }
            if (!encontrado){
                System.out.println("Esta categoria não possui livros cadastrados.");
            }
        }
    }

    public List<Livro11> getLivro11s() {
        return livro11s;
    }

    public void setLivro11s(List<Livro11> livro11s) {
        this.livro11s = livro11s;
    }
}
