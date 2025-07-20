package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Biblioteca08;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livro08;

import java.util.*;

public class LivroTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca08 biblioteca08 = new Biblioteca08();

        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastrar livro.");
            System.out.println("[2] Listar livros.");
            System.out.println("[3] Buscar livro por autor.");
            System.out.println("[4] Alterar livro.");
            System.out.println("[5] Excluir Livro.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERRO. Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    String titulo = Biblioteca08.validandoTitulo(scanner);
                    String autor = Biblioteca08.valindadoAutor(scanner);
                    int ano = Biblioteca08.validandoAno(scanner);
                    String categoria = Biblioteca08.validandoCategoria(scanner);
                    Livro08 livro08 = new Livro08(titulo,autor,ano,categoria);
                    biblioteca08.cadastroLivro(livro08);
                    break;

                case 2:
                    biblioteca08.listarLivros();
                    break;

                case 3:
                    String autoBuscarAutor = Biblioteca08.valindadoAutor(scanner);
                    biblioteca08.buscaPorAutor(autoBuscarAutor);
                    break;

                case 4:
                    if (biblioteca08.getLivro08s().isEmpty()){
                        System.out.println("Cadastre livros.Lista vazia.");
                    }else {
                        System.out.println("Escolha um livro do indice para alterar.");
                        for (int i = 0; i < biblioteca08.getLivro08s().size(); i++) {
                            System.out.println("["+i+"]"+biblioteca08.getLivro08s().get(i));
                        }
                        int cadastro=0;
                        try {
                            System.out.print("Digite o número de cadastro do livro:");
                            cadastro = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Digite um valor válido.");
                        }
                        biblioteca08.alterarDadosLivro(scanner,cadastro);
                    }
                    break;

                case 5:
                    if(biblioteca08.getLivro08s().isEmpty()){
                        System.out.println("Lista vazia. Cadastre livros.");
                    }else {
                        int cadastro = 0;
                        try {
                            System.out.print("Digite o número de cadastro do livro:");
                            cadastro = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Digite um indice válido.");
                        }
                        biblioteca08.excluirLivro(cadastro);
                    }
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
