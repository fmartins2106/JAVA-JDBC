package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Biblioteca10;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livro10;

import java.util.Scanner;

public class LivroTest10 {
    public static void main(String[] args) {
        Biblioteca10 biblioteca10 = new Biblioteca10();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de livro.");
            System.out.println("[2] Lista de livros cadastrados.");
            System.out.println("[3] Buscar livros.");
            System.out.println("[4] Alterar dados livro.");
            System.out.println("[5] Excluir livro.");
            System.out.println("[6] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    String titulo = Biblioteca10.validandoTitulo(scanner);
                    String autor = Biblioteca10.validandoAutor(scanner);
                    int ano = Biblioteca10.validandoAno(scanner);
                    String categoria = Biblioteca10.validandoCategoria(scanner);
                    Livro10 livro10 = new Livro10(titulo,autor,ano,categoria);
                    biblioteca10.addLivroLista(livro10);
                    break;

                case 2:
                    biblioteca10.listandoLivros();
                    break;

                case 3:
                    biblioteca10.buscarLivrosAutor(scanner);
                    break;

                case 4:
                    biblioteca10.alterarDadosLivro(scanner);
                    break;

                case 5:
                    biblioteca10.excluirLivros(scanner);
                    break;

                case 6:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
}
