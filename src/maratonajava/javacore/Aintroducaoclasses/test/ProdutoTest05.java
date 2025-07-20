package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto05;

import java.util.*;

public class ProdutoTest05 implements Cloneable{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Produto05> produto05s = new ArrayList<>();

        while (true){
            int opcao=0;
            System.out.println("Escolha uma das opções abaixo!");
            System.out.println("[ 1 ] Cadastro de Produto.");
            System.out.println("[ 2 ] Listar produtos.");
            System.out.println("[ 3 ] Ordernar Produtos por Preço.");
            System.out.println("[ 4 ] Sair.");
            System.out.print("Digite uma opção:");
            if (scanner.hasNextInt()){
                opcao = scanner.nextInt();
                scanner.nextLine();
            }else {
                System.out.println("Opção inválita. Tente novamente.");
                scanner.nextLine();
                continue;
            }
            switch (opcao){
                case 1:
                    String nome = Produto05.validandoNomeProduto(scanner);
                    double valor = Produto05.validandoValorProduto(scanner);
                    String categoria = Produto05.validandoCategoriaProduto(scanner);
                    Produto05 produto05 = new Produto05(nome,valor, categoria);
                    produto05s.add(produto05);
                    break;

                case 2:
                    if (produto05s.isEmpty()){
                        System.out.println("Nenhum produto cadastrado até o momento.");
                    }else {
                        for (int i = 0; i < produto05s.size(); i++) {
                            Produto05 produto = produto05s.get(i);
                            produto.listarProdutos(i, produto05s.size());
                        }
                    }
                    break;
                case 3:
                    if (produto05s.isEmpty()){
                        System.out.println("Nenhum produto foi cadastradoa até o momento.");
                    }else {
                        ArrayList<Produto05> cloneLista = new ArrayList<>();
                        for (Produto05 produto : produto05s){
                            cloneLista.add(produto.clone());
                        }
                        Collections.sort(cloneLista, Comparator.comparingDouble(Produto05::getValor));
                        System.out.println("Produtos ordenados:");
                        for (int i = 0; i < cloneLista.size(); i++) {
                            Produto05 produto = cloneLista.get(i);
                            produto.listarProdutos(i, cloneLista.size());
                        }
                    }
                    break;
                case 4:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("ERRO.Tente novamente.");
            }
        }
    }
}
