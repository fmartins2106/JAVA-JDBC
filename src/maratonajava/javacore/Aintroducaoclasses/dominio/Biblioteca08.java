package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.time.Year;
import java.util.*;


public class Biblioteca08 {
    private ArrayList<Livro08> livro08s;

    public Biblioteca08(){
        this.livro08s = new ArrayList<>();
    }
     public void cadastroLivro(Livro08 livro){
        livro08s.add(livro);
     }

     public void listarLivros(){
        if (livro08s.isEmpty()){
            System.out.println("Lista vazia, cadastre livros.");
        }else {
            livro08s.forEach(livro -> System.out.println(livro));
        }
     }
     public void buscaPorAutor(String autor){
        boolean encontrado = false;
        for (Livro08 livro : livro08s){
            if (livro.getAutor().equalsIgnoreCase(autor)){
                System.out.println(livro);
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Nenhum livro foi encontrado.");
        }
     }

     public void alterarDadosLivro(Scanner scanner, int indice){
        if (indice < 0 || indice >= livro08s.size()){
            System.out.println("Indice não encontrado. Tente novamente.");
        }else {
            Livro08 livros = livro08s.get(indice);
            livros.setTitulo(Biblioteca08.validandoTitulo(scanner));
            livros.setAutor(Biblioteca08.valindadoAutor(scanner));
            livros.setAno(Biblioteca08.validandoAno(scanner));
            livros.setCategoria(Biblioteca08.validandoCategoria(scanner));
        }
     }
     public ArrayList<Livro08> getLivro08s(){
         return livro08s;
     }

    public void setLivro08s(ArrayList<Livro08> livro08s) {
        this.livro08s = livro08s;
    }

    public static String validandoTitulo(Scanner scanner){
        while (true){
            System.out.print("Título:");
            String titulo = scanner.nextLine().trim();
            if (titulo.isEmpty() || !titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("Campo titulo não pode ser vazio ou conter caracteres.");
                continue;
            }
            return Livro08.formatoNome(titulo);
        }
     }
     public static String valindadoAutor(Scanner scanner){
         while (true){
             System.out.println("Autor:");
             String autor = scanner.nextLine().trim();
             if (autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                 System.out.println("Digite nome completo. Campo nome não pode ser vaziou ou conter caracteres.");
                 continue;
             }
             return Livro08.formatoNome(autor);
         }
     }
     public static int validandoAno(Scanner scanner){
        int anoAtual = Year.now().getValue();
        while (true){
            try {
                System.out.print("Ano:");
                int ano = Integer.parseInt(scanner.nextLine());
                if (ano < 1500 || ano > anoAtual){
                    System.out.println("Ano precisa ser maior que 1500 e menor que ano atual.");
                    continue;
                }
                return ano;
            }catch (NumberFormatException e){
                System.out.println("Digite um ano válido.");
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
            return Livro08.formatoNome(categoria);
        }
     }

     public void excluirLivro(int indice){
         if (indice >=0 && indice < livro08s.size()){
             livro08s.remove(indice);
             System.out.println("Livro excluido com sucesso.");
         }else {
             System.out.println("Indice não encontrado. Tente novamente.");
         }
     }
}
