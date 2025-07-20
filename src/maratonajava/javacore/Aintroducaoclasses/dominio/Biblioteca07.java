package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;


import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca07 {
    private ArrayList<Livro07> livro07s;

    public Biblioteca07(){
        this.livro07s = new ArrayList<>();
    }

    public void cadastroLivro(Livro07 livro){
        livro07s.add(livro);
    }
    public void listarLivros(){
        if (livro07s.isEmpty()){
            System.out.println("Nenhum livro cadastrado.");
        }else {
            livro07s.forEach(livro -> System.out.println(livro));
        }
    }
    public void buscarPorAutor(String autor){
        boolean encontrado = false;
        for (Livro07 livro : livro07s){
            if (livro.getAutor().equalsIgnoreCase(autor)){
                System.out.println(livro);
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Nenhum livro foi encontrado.");
        }
    }

    public void alterarDadosLivros(Scanner scanner, int indice){
        if (indice >=0 && indice < livro07s.size()){
            Livro07 livro07 = livro07s.get(indice);
            livro07.setTitulo(Biblioteca07.validandoNome(scanner));
            livro07.setAutor(Biblioteca07.validandoAutor(scanner));
            livro07.setAno(Biblioteca07.validandoAno(scanner));
            livro07.setCategoria(Biblioteca07.validandoCategoria(scanner));
            System.out.println("Livro alterado com sucesso.");
        }else {
            System.out.println("Indice inválido.");
        }
    }

    public void excluirLivro(int indice){
        if (indice>=0 && indice< livro07s.size()){
            livro07s.remove(indice);
            System.out.println("Livro excluido com sucesso.");
        }else {
            System.out.println("Indice inválido.");
        }
    }
    public ArrayList<Livro07>getLivro07s(){
        return livro07s;
    }


    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Título:");
            String titulo = scanner.nextLine().trim();
            if (titulo.isEmpty() || !titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("ERRO. Campo titulo não pode ser vazio ou conter caracteres. Tente novamente.");
            }else {
                return Livro07.formatoNomes(titulo);
            }
        }
    }
    public static String validandoAutor(Scanner scanner){
        while (true){
            System.out.print("Autor:");
            String autor = scanner.nextLine().trim();
            if (autor.isEmpty() || !autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                System.out.println("Campo autor não pode ser vazio, conter caracteres ou nome incompleto. Tente novamente.");
            }else {
                return Livro07.formatoNomes(autor);
            }
        }
    }
    public static int validandoAno(Scanner scanner){
        int anoAtual = Year.now().getValue();
        while (true){
            try {
                System.out.print("Ano:");
                int ano = Integer.parseInt(scanner.nextLine());
                    if (ano<1500 || ano > anoAtual){
                        System.out.println("Ano não pode ser menor que 1500 e maior que ano atual. Tente novamente.");
                    }else {
                        return ano;
                    }
            }catch (NumberFormatException e){
                System.out.println("ERRO. Digite um valor válido.");
            }
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                System.out.println("ERRO. Campo categoria não pode ficar vazio ou conter caracteres. Tente novamente.");
            }else {
                return Livro07.formatoNomes(categoria);
            }
        }
    }


}

