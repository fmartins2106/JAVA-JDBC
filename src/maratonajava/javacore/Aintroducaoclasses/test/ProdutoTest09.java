package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto09;

import java.util.*;

public class ProdutoTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto09> produto09s = new ArrayList<>();

        while (true){
            int opcao=0;
            System.out.println("[ 1 ] Cadastrar produto.");
            System.out.println("[ 2 ] Relatório produto.");
            System.out.println("[ 3 ] Relatório ordem preço.");
            System.out.println("[ 4 ] Alterar cadastro produto.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao<=0 || opcao>=6){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO: Digite uma opção válida. Tente novamente.");
            }
            switch (opcao){
                case 1:
                    String nome = Produto09.validandoNome(scanner);
                    double valor = Produto09.validandoValor(scanner);
                    String categoria = Produto09.validandoCategoria(scanner);
                    Produto09 produto09 = new Produto09(nome,valor,categoria);
                    produto09s.add(produto09);
                    break;

                case 2:
                    if (produto09s.isEmpty()){
                        System.out.println("Lista vazia, cadastre produtos.");;
                    }else {
                        for (int i = 0; i < produto09s.size(); i++) {
                            Produto09 produto10 = produto09s.get(i);
                            produto10.exibindoTabelaProdutos(i, produto09s.size());
                        }
                    }
                    break;

                case 3:
                    if (produto09s.isEmpty()){
                        System.out.println("Lista vazia, cadastre produtos primeiro.");
                    }else {
                        ArrayList<Produto09> cloneList = new ArrayList<>();
                        for (Produto09 produtos : produto09s){
                            cloneList.add(produtos.clone());
                        }
                        Collections.sort(cloneList,Comparator.comparingDouble(Produto09::getValor));
                        for (int i = 0; i < cloneList.size(); i++) {
                            Produto09 produtos = cloneList.get(i);
                            produtos.exibindoTabelaProdutos(i, cloneList.size());
                        }
                    }
                    break;

                case 4:
                    if (produto09s.isEmpty()){
                        System.out.println("Lista vazia, cadastre produtos.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite a matricula:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula<0 || matricula>=produto09s.size()){
                                    System.out.println("ERRO. Tente novamente.");
                                }else {
                                    Produto09 produtosAlterados = produto09s.get(matricula);
                                    String novoNome = Produto09.validandoNome(scanner);
                                    produtosAlterados.setNome(novoNome);
                                    double novoValor = Produto09.validandoValor(scanner);
                                    produtosAlterados.setValor(novoValor);
                                    String novaCategoria = Produto09.validandoCategoria(scanner);
                                    produtosAlterados.setCategoria(novaCategoria);
                                    break;
                                }
                            }catch (NumberFormatException erro){
                                System.out.println("Digite um valor válido. Tente novamente.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>Finalizando o programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida. Tente novamente.");
            }
        }
    }
}
