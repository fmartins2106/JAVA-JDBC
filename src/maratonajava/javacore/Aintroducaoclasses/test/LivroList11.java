package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Biblioteca11;

import java.util.Scanner;

public class LivroList11 {
    public static void main(String[] args) {
        Biblioteca11 biblioteca11 = new Biblioteca11();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastrar livro.");
            System.out.println("[2] Listar livro.");
            System.out.println("[3] Alterar cadastro livro.");
            System.out.println("[4] Excluir livro.");
            System.out.println("[5] Pesquisa por categoria.");
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
                    String titulo = Biblioteca11.validandoTitulo(scanner);
                    String autor = Biblioteca11.validandoAutor(scanner);
                    int ano = Biblioteca11.validandoAno(scanner);
                    String categoria = Biblioteca11.validandoCategoria(scanner);
                    Livro11 livro11 = new Livro11(titulo,autor,ano,categoria);
                    biblioteca11.addLivros(livro11);
                    break;

                case 2:
                    biblioteca11.listaLivros(scanner);
                    break;

                case 3:
                    biblioteca11.alterarDadosLivro(scanner);
                    break;

                case 4:
                    biblioteca11.excluirLivro(scanner);
                    break;

                case 5:
                    biblioteca11.pesquisaPorCategoria(scanner,biblioteca11.getLivro11s());
                    break;

                case 6:
                    System.out.println(">>>Finalizando programa...");
                    return;

                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
}
