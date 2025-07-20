package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import java.util.*;

public class ProdutoTest10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto10> produto10s = new ArrayList<>();

        while (true){
            int opcao = 0;
            System.out.println("[ 1 ] - Cadastro de produto.");
            System.out.println("[ 2 ] - Relatório produtos cadastrados.");
            System.out.println("[ 3 ] - Relatório por ordem de preço.");
            System.out.println("[ 4 ] - Alterar cadastro produto.");
            System.out.println("[ 5 ] - Sair.");
            try {
                System.out.print("Digite uma da opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao<=0 || opcao >=6){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido. Tente novamente.");
            }
            switch (opcao){

                case 1:
                    String nome = Produto10.validandoNome(scanner);
                    double valor = Produto10.validandoValor(scanner);
                    String categoria = Produto10.validandoCategoria(scanner);
                    Produto10 produto10 = new Produto10(nome,valor,categoria);
                    produto10s.add(produto10);
                    break;

                case 2:
                    if (produto10s.isEmpty()){
                        System.out.println("Lista vazio. Cadastre produtos.");
                    }else {
                        for (int i = 0; i < produto10s.size(); i++) {
                            Produto10 produtos = produto10s.get(i);
                            produtos.tabelaProdutosCadastrados(i, produto10s.size());
                        }
                    }
                    break;

                case 3:
                    if (produto10s.isEmpty()){
                        System.out.println("ERRO. Não há produtos cadastrados.");
                    }else {
                        ArrayList<Produto10> cloneList = new ArrayList<>();
                        for (Produto10 produto : produto10s){
                            cloneList.add(produto.clone());
                        }
                        Collections.sort(cloneList, Comparator.comparingDouble(Produto10::getValor));
                        for (int i = 0; i < cloneList.size(); i++) {
                            Produto10 protudosCloneList = cloneList.get(i);
                            protudosCloneList.tabelaProdutosCadastrados(i, cloneList.size());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Alterar informações cadastro.");
                    if (produto10s.isEmpty()){
                        System.out.println("Lista vazia. Cadastre produtos.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o número de cadastro do produto:");
                                int cadastro = Integer.parseInt(scanner.nextLine());
                                if (cadastro<0 || cadastro>= produto10s.size()){
                                    System.out.println("ERRO. Digite um número de cadastro válido. Tente novamente.");
                                }else {
                                    Produto10 produtoAlterado = produto10s.get(cadastro);
                                    String novoNome = Produto10.validandoNome(scanner);
                                    produtoAlterado.setNome(novoNome);
                                    double novoValor = Produto10.validandoValor(scanner);
                                    produtoAlterado.setValor(novoValor);
                                    String novaCategoria = Produto10.validandoCategoria(scanner);
                                    produtoAlterado.setCategoria(novaCategoria);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println("Digite uma matricula válida.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Erro. Tente novamente.");


            }
        }
    }
}
