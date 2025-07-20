package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livro05;

import java.util.*;

public class LivroTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Livro05> livro05s = new ArrayList<>();

        while (true) {
            String titulo = "";
            while (true) {
                System.out.print("Título do livro:");
                titulo = scanner.nextLine().trim();
                if (titulo.isEmpty()) {
                    System.out.println("Nome não pode ser vazio, tente novamente.");
                } else {
                    if (!titulo.matches("^[\\p{L}]+( [\\p{L}]+)*$")) {
                        System.out.println("Campo não aceita caracteres. Tente novamente.");
                    } else {
                        break;
                    }
                }
            }
            String autor = "";
            while (true) {
                System.out.print("Digite o autor:");
                autor = scanner.nextLine().trim();
                if (autor.isEmpty()) {
                    System.out.println("Campo autor não pode ser vazio. Tente novamente.");
                } else {
                    if (!autor.matches("^[\\p{L}]+( [\\p{L}]+)+$")) {
                        System.out.println("Digite o nome completo, sem caracteres para validar.");
                    } else {
                        break;
                    }
                }
            }
            double valor = Livro05.valorDoLivro(scanner);
            int quantidade = Livro05.quantidadeDeLivros(scanner);
            Livro05 livro05 = new Livro05(titulo, autor, valor, quantidade);
            livro05s.add(livro05);
            String addNovoLivro;
            while (true) {
                System.out.print("Quer adicionar outro livro?(sim/não):");
                addNovoLivro = scanner.nextLine().trim().toLowerCase();
                if (addNovoLivro.equals("sim") || addNovoLivro.equals("não")) {
                    break;
                } else {
                    System.out.println("ERRO. Digite apenas sim ou não.");
                }
            }
            if (addNovoLivro.equals("não")) {
                for (int i = 0; i < livro05s.size(); i++) {
                    Livro05 livro6 = livro05s.get(i);
                    livro6.exibindoResultadosLivros(i, livro05s.size());
                }
                break;
            }
        }
        while (true) {
            try {
                System.out.print("Quer excluir qual livro do sitema?(Digite 999 para sair):");
                int exLivro = Integer.parseInt(scanner.nextLine());
                if (exLivro == 999) {
                    System.out.println(">>>Finalizando o programa...");
                    break;
                }
                if (exLivro < 0 || exLivro >= livro05s.size()) {
                    System.out.println("Indice inválido. tente novamente.");
                } else {
                    livro05s.remove(exLivro);
                    System.out.println("Livro removido com sucesso.");
                    for (int i = 0; i < livro05s.size(); i++) {
                        livro05s.get(i).exibindoResultadosLivros(i, livro05s.size());
                    }

                }
            } catch (NumberFormatException erro) {
                System.out.println("ERRO. Tente um númoro do indice válido.");
            }
        }
    }
}
