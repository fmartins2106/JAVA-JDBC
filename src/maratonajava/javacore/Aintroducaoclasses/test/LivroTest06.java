package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.introducao.Livro06;

import java.util.*;

public class LivroTest06 {
    public static void main(String[] args) {
        Scanner scannerLivros06 = new Scanner(System.in);
        ArrayList<Livro06> livro06s = new ArrayList<>();

        while (true){
            String titulo = Livro06.verificandoTitulo(scannerLivros06);
            String autor = Livro06.verificandoAutor(scannerLivros06);
            double valor = Livro06.verificandoValor(scannerLivros06);
            int quantidade = Livro06.verificandoQuantidade(scannerLivros06);
            Livro06 livro06 = new Livro06(titulo,autor,valor,quantidade);
            livro06s.add(livro06);
            String addNovoLivro;
            do {
                System.out.print("Quer adicionar outro livro?(sim/não):");
                addNovoLivro = scannerLivros06.nextLine().trim().toLowerCase();
            }while (!addNovoLivro.equals("não") && !addNovoLivro.equals("sim"));
            if (addNovoLivro.equals("não")){
                for (int i = 0; i < livro06s.size(); i++) {
                    Livro06 livros = livro06s.get(i);
                    livros.monstrandoTabelaLivros(i,livro06s.size());
                }
                break;
            }

        }
        while (true){
            try {
                System.out.print("Quer excluir qual livro?(Digite 999 para parar):");
                int index = Integer.parseInt(scannerLivros06.nextLine());
                if (index==999){
                    System.out.println(">>>Finalizando programa...");
                    break;
                }else {
                    if (index<0 || index <= livro06s.size()){
                        livro06s.remove(index);
                        for (int i = 0; i < livro06s.size(); i++) {
                            Livro06 livros = livro06s.get(i);
                            livros.monstrandoTabelaLivros(i,livro06s.size());
                        }
                    }else {
                        System.out.println("ERRO. Número inválido. Tente novamente.");
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO:"+erro.getMessage());
            }
        }

    }
}
