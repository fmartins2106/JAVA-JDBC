package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Biblioteca09;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livro09;

import java.util.*;

public class LivroTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca09 biblioteca09 = new Biblioteca09();
        while (true){
            int opcao=0;
            System.out.println("[1] Cadastrar Livro.");
            System.out.println("[2] Listar Livros.");
            System.out.println("[3] Buscar livro.");
            System.out.println("[4] Alterar dados livro.");
            System.out.println("[5] Excluir livro.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    String titulo = Biblioteca09.validandoTitulo(scanner);
                    String autor = Biblioteca09.validandoAutor(scanner);
                    int ano = Biblioteca09.validandoAno(scanner);
                    String categoria = Biblioteca09.validandoCategoria(scanner);
                    Livro09 livro09 = new Livro09(titulo,autor,ano,categoria);
                    biblioteca09.addLivros(livro09);
                    break;

                case 2:
                    biblioteca09.listaLivros();
                    break;

                case 3:
                    if (biblioteca09.getLivro09s().isEmpty()){
                        System.out.println("Lista vazia. Cadastre livros.");
                    }else {
                        System.out.print("Digite o nome do autor:");
                        String pesquisaAutor = Biblioteca09.validandoAutor(scanner);
                        biblioteca09.pesquisaAutor(pesquisaAutor);
                    }
                    break;

                case 4:
                    if (biblioteca09.getLivro09s().isEmpty()){
                        System.out.println("Lista vazia, cadastre livros.");
                    }else {
                        for (int i = 0; i < biblioteca09.getLivro09s().size(); i++) {
                            System.out.println("["+i+"] livro: "+biblioteca09.getLivro09s().get(i));
                        }
                        int indice=0;
                        try {
                            System.out.print("Digite o indice do livro:");
                            indice = Integer.parseInt(scanner.nextLine());

                        }catch (NumberFormatException e){
                            System.out.println("Digite um valor válido.");
                        }
                        biblioteca09.alterarDadosLivro(scanner,indice);
                    }
                    break;

                case 5:
                    if (biblioteca09.getLivro09s().isEmpty()){
                        System.out.println("Lista vazia.");
                    }else {
                        for (int i = 0; i < biblioteca09.getLivro09s().size(); i++) {
                            System.out.println("["+i+"] livro:"+biblioteca09.getLivro09s().get(i));
                        }
                        int indice=0;
                        try {
                            System.out.print("Digite o indice do livro:");
                            indice = Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Digite um valor válidoo.");
                        }
                        biblioteca09.excluirLivro(scanner,indice);

                    }
                    break;

                case 6:
                    System.out.println(">>Finalizando o programa.");
                    return;
                default:
                    System.out.println("ERRO. Digite uma opção válida.");
            }
        }
    }




}
