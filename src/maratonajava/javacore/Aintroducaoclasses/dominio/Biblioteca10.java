package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca10 {
    private List<Livro10> livro10s;

    public Biblioteca10(){
        this.livro10s = new ArrayList<>();
    }

    public void addLivroLista(Livro10 livro10){
        livro10s.add(livro10);
    }

    public static String validandoTitulo(Scanner scanner){
        while (true){
            System.out.print("Título:");
            String titulo = scanner.nextLine().trim();
            if (titulo.isEmpty() || !titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo título não pode ficar vazio ou conter caracteres.");
                continue;
            }
            return Livro10.formatoNome(titulo);
        }
    }
    public static String validandoAutor(Scanner scanner){
        while (true){
            System.out.print("Autor:");
            String autor = scanner.nextLine().trim();
            if (autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Digite nome completo sem caracteres.");
                continue;
            }
            return Livro10.formatoNome(autor);
        }
    }
    public static int validandoAno(Scanner scanner){
        while (true){
            int anoAtual = Year.now().getValue();
            try {
                System.out.print("Ano:");
                int ano = Integer.parseInt(scanner.nextLine());
                if (ano <1500 || ano > anoAtual){
                    System.out.println("Ano precisa ser maior que 1500 e menor que ano atual.");
                }
                return ano;
            }catch (NumberFormatException e){
                System.out.println("Digite um númer válido.");
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
            return Livro10.formatoNome(categoria);
        }
    }

    public void listandoLivros(){
        if (livro10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            livro10s.forEach(System.out::println);
        }
    }
    public void buscarLivrosAutor(Scanner scanner){
        if (livro10s.isEmpty()){
            System.out.println("Lista vazia");
        }else {
            System.out.println("Para pesquisar, digite o nome do autor.");
            String autor = validandoAutor(scanner);
            boolean encontrado = false;
            for (Livro10 livro10 : livro10s){
                if (autor.equalsIgnoreCase(livro10.getAutor())){
                    System.out.println("Título:"+livro10.getTitulo());
                    System.out.println("Autor:"+livro10.getAutor());
                    System.out.println("Ano:"+livro10.getAno());
                    System.out.println("Categoria:"+livro10.getCategoria());
                    encontrado = true;
                }
            }
            if (!encontrado){
                System.out.println("Livro não encontrado.");
            }
        }
    }
    public void alterarDadosLivro(Scanner scanner){
        if (livro10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (int i = 0; i < livro10s.size(); i++) {
                System.out.println("["+i+"] Livro:"+livro10s.get(i));
            }
            try {
                System.out.print("Digite o código do livro:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Livro10 livro10 = livro10s.get(codigo);
                livro10.setTitulo(validandoTitulo(scanner));
                livro10.setAutor(validandoAutor(scanner));
                livro10.setAno(validandoAno(scanner));
                livro10.setCategoria(validandoCategoria(scanner));
                System.out.println("Dados alteradoso com sucesso.");
            }catch (NumberFormatException e){
                System.out.println("ERRO. Digite um valor válido.");
            }
        }
    }
    public void excluirLivros(Scanner scanner){
        if (livro10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (int i = 0; i < livro10s.size(); i++) {
                System.out.println("["+i+"] Livro->"+livro10s.get(i));
            }
            try {
                System.out.print("Digite o código do livro:");
                int codigo = Integer.parseInt(scanner.nextLine());
                livro10s.remove(codigo);
                System.out.println("Livro excluido com sucesso.");
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

}
