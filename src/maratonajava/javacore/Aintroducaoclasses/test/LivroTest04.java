package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livro04;

import java.util.*;

public class LivroTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Livro04> livro04s = new ArrayList<>();

        while (true){
            String titulo="";
            while (true){
                System.out.print("Digite o titulo do livro:");
                titulo = scanner.nextLine().trim();
                if (titulo.isEmpty()){
                    System.out.println("Campo não pode ser vazio. Tente novamente.");
                }else {
                    if (!titulo.matches("^[\\p{all}]+( [\\p{all}]+)*$")){
                        System.out.println("Tente Novamente.");
                    }else {
                        break;
                    }
                }
            }
            String autor="";
            while (true){
                System.out.print("Autor:");
                autor = scanner.nextLine().trim();
                if (autor.isEmpty()){
                    System.out.println("Campo autor não pode ser vazio. Tente novamente.");
                }else {
                    if (!autor.matches("^[\\p{all}]+( [\\p{all}]+)+$")){
                        System.out.println("Digite o nome completo do autor. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            double valor = Livro04.valorValido(scanner);
            int quantidade = Livro04.quantidadeValida(scanner);
            Livro04 livro04 = new Livro04(titulo,autor,valor,quantidade);
            livro04s.add(livro04);
            String addNovoLivro="";
            while (true){
                System.out.print("Quer adicionar outro livro?(sim/não):");
                addNovoLivro = scanner.nextLine().trim().toLowerCase();
                if (addNovoLivro.equals("sim") || addNovoLivro.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (addNovoLivro.equals("não")){
                for (int p=0;p<livro04s.size();p++) {
                    Livro04 livro = livro04s.get(p);
                    livro.exibindoDadosLivros(p, livro04s.size());
                }
                int excluirLivro=0;
                while (true){
                    System.out.print("Qual livro que excluir da lista(Digite 999 para parar.):?");
                    excluirLivro = Integer.parseInt(scanner.nextLine());
                    if (excluirLivro==999){
                        System.out.println(">>>Finalizando o programa.");
                        break;
                    }else {
                        if (excluirLivro<livro04s.size()){
                            livro04s.remove(excluirLivro);
                            System.out.println("Livro excluido com sucesso.");
                            for (int i=0;i<livro04s.size();i++){
                                livro04s.get(i).exibindoDadosLivros(i,livro04s.size());
                            }

                        }
                    }
                }
                break;

            }

        }

    }
}
