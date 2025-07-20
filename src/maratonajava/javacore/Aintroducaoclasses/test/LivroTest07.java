package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Biblioteca07;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livro07;

import java.util.*;

public class LivroTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca07 biblioteca07 = new Biblioteca07();

        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastrar livro.");
            System.out.println("[2] Listar livros cadastrados.");
            System.out.println("[3] Buscar livros autor.");
            System.out.println("[4] Alterar livro.");
            System.out.println("[5] Excluir livro.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Escolha uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao< 0 || opcao>6){
                    System.out.println("Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    String titulo = Biblioteca07.validandoNome(scanner);
                    String autor = Biblioteca07.validandoAutor(scanner);
                    int ano = Biblioteca07.validandoAno(scanner);
                    String categoria = Biblioteca07.validandoCategoria(scanner);
                    Livro07 livro07 = new Livro07(titulo,autor,ano,categoria);
                    biblioteca07.cadastroLivro(livro07);
                    break;

                case 2:
                    System.out.println("Listar livros cadastrados.");
                    biblioteca07.listarLivros();
                    break;

                case 3:
                    System.out.println("Buscar livro por autor.");
                    String autoBuscarAutor = Biblioteca07.validandoAutor(scanner);
                    biblioteca07.buscarPorAutor(autoBuscarAutor);
                    break;

                case 4:
                        if (biblioteca07.getLivro07s().isEmpty()){
                            System.out.println("Lista vazia. Cadastre livros primeiro.");
                        }else {
                            System.out.println("Escolha um livro do indice a ser alterado:");
                            for (int i = 0; i< biblioteca07.getLivro07s().size();i++){
                                System.out.println("["+i+"]"+biblioteca07.getLivro07s().get(i));
                            }
                            int indice =-1;
                            try {
                                System.out.println("Digite o indice do livro a ser alterado.");
                                indice = Integer.parseInt(scanner.nextLine());
                            }catch (NumberFormatException e){
                                System.out.println("Valor inválido, tente novamente.");
                            }
                            if (indice >=0 && indice < biblioteca07.getLivro07s().size()){
                                biblioteca07.alterarDadosLivros(scanner,indice);
                            }else {
                                System.out.println("Indice inválido.");
                            }
                        }
                        break;

                case 5:
                    System.out.println("Excluir livro.");
                    if (biblioteca07.getLivro07s().isEmpty()){
                        System.out.println("Lista vazia. Cadastre um livro primeiro.");
                    }else {
                        System.out.println("Escolha um livro do indice a ser alterado:");
                        for (int i = 0; i < biblioteca07.getLivro07s().size(); i++) {
                            System.out.println("["+i+"]"+biblioteca07.getLivro07s().get(i));
                        }
                        int indice =-1;
                        try {
                            System.out.println("Digite o número do indice a ser alterado.");
                            indice = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Valor inválido, tente novamente.");
                        }
                        if (indice>=0 && indice< biblioteca07.getLivro07s().size()){
                            biblioteca07.excluirLivro(indice);
                        }
                    }
                    break;

                case 6:
                    System.out.println(">>>Finalizando o sistema.");
                    return;
                default:
                    System.out.println("ERRO. Tente uma opção válida. Tente novamente.");
            }
        }
    }
}
