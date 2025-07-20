package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto05;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto06;


import java.util.*;

public class ProdutoTest06 {
    public static void main(String[] args) {
        Scanner scannerProduto06 = new Scanner(System.in);

        ArrayList<Produto06> produto06s = new ArrayList<>();
        while (true){
            int opcao=0;
            System.out.println("Escolha uma das opções abaixo.");
            System.out.println("[ 1 ] Adicionar um produto.");
            System.out.println("[ 2 ] Listar produtos.");
            System.out.println("[ 3 ] Excluir produtos.");
            System.out.println("[ 4 ] Ordenar por preço.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma das opções:");
                opcao = Integer.parseInt(scannerProduto06.nextLine());
                if (opcao<0 || opcao > 6){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage()+"Tente novamente.");
            }
            switch (opcao){
                case 1:
                    String nome = Produto06.verificandoNome(scannerProduto06);
                    double valor = Produto06.verificandoValor(scannerProduto06);
                    String categoria = Produto05.validandoCategoriaProduto(scannerProduto06);
                    Produto06 produtos = new Produto06(nome,valor,categoria);
                    produto06s.add(produtos);
                    break;
                case 2:
                    if (produto06s.isEmpty()){
                        System.out.println("Lista vazia, cadastre um produto primeiro.");
                    }else {
                        for (int i = 0; i < produto06s.size(); i++) {
                            Produto06 produto = produto06s.get(i);
                            produto.monstrandoTabelProduto(i, produto06s.size());
                        }
                    }
                    break;
                case 3:
                    if (produto06s.isEmpty()){
                        System.out.println("ERRO. Lista vazia, cadastre um produto primeiro.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Qual produto que excluir?:");
                                int index = Integer.parseInt(scannerProduto06.nextLine());
                                if (opcao <= produto06s.size()){
                                    produto06s.remove(index);
                                    for (int i = 0; i < produto06s.size(); i++) {
                                        Produto06 produto = produto06s.get(i);
                                        produto.monstrandoTabelProduto(i,produto06s.size());
                                    }
                                    break;
                                }else {
                                    System.out.println("ERRO. Tente novamente um indice válido.");
                                }
                            }catch (NumberFormatException e){
                                System.out.println("ERRO:"+e.getMessage());
                            }
                        }
                    }
                case 4:
                    if (produto06s.isEmpty()){
                        System.out.println("ERRO. Lista vazia, cadastre um produto primeiro.");
                    }else {
                        ArrayList<Produto06> cloneLista = new ArrayList<>();
                        for (Produto06 produto : produto06s) {
                            cloneLista.add(produto.clone());
                        }
                        Collections.sort(cloneLista, Comparator.comparingDouble(Produto06::getValor));
                        for (int i = 0; i < cloneLista.size(); i++) {
                            Produto06 cloneProdutos = cloneLista.get(i);
                            cloneProdutos.monstrandoTabelProduto(i, cloneLista.size());
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>.Finalizando o programa...");
                    return;
                default:
                    System.out.println("ERRO. Opção inválida, tente novamente.");
            }
        }
    }
}
