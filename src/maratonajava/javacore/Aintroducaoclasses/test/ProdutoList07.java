package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto07;


import java.util.*;

public class ProdutoList07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto07> produto07s = new ArrayList<>();

        while (true){
            int opcao= 0;
            System.out.println("[ 1 ] Cadastrar um produto.");
            System.out.println("[ 2 ] Relatório produto cadastrado.");
            System.out.println("[ 3 ] Relatório por preço.");
            System.out.println("[ 4 ] Alterar cadastro produto.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao<= 0 || opcao>=6){
                    System.out.println("ERRO. Digite uma opção válida.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO:"+e.getMessage());
            }

            switch (opcao){
                case 1:
                    String nome = Produto07.validandoNome(scanner);
                    double valor = Produto07.validandoValor(scanner);
                    String categoria = Produto07.verificandoCategoria(scanner);
                    Produto07 produto = new Produto07(nome,valor,categoria);
                    produto07s.add(produto);
                    break;

                case 2:
                    if (produto07s.isEmpty()){
                        System.out.println("Lista está vazia. Cadastre um produto.");
                    }else {
                        for (int i = 0; i < produto07s.size(); i++) {
                            Produto07 produto07 = produto07s.get(i);
                            produto07.exibindoResultados(i,produto07s.size());
                        }
                    }
                    break;
                case 3:
                    if (produto07s.isEmpty()){
                        System.out.println("Lista vazia, adicione produtos.");
                    }else {
                        ArrayList<Produto07> cloneList = new ArrayList<>();
                        for (Produto07 produto07 : produto07s){
                            cloneList.add(produto07.clone());
                        }
                        Collections.sort(cloneList, Comparator.comparingDouble(Produto07::getValor));
                        for (int i = 0; i < cloneList.size(); i++) {
                            Produto07 produto07 = cloneList.get(i);
                            produto07.exibindoResultados(i,cloneList.size());
                        }
                    }
                    break;
                case 4:
                    if (produto07s.isEmpty()){
                        System.out.println("Lista está vazia. Cadastre um produto.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite o código de cadastro.");
                                int codigo = Integer.parseInt(scanner.nextLine());
                                if (codigo<0 || codigo>= produto07s.size()){
                                    System.out.println("ERRO. Digite um código válido. Tente novamente.");
                                }else {
                                    Produto07 produto07 = produto07s.get(codigo);
                                    String novoNome = Produto07.validandoNome(scanner);
                                    produto07.setNome(novoNome);
                                    double novoValor = Produto07.validandoValor(scanner);
                                    produto07.setValor(novoValor);
                                    String novaCategoria = Produto07.verificandoCategoria(scanner);
                                    produto07.setCategoria(novaCategoria);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println(">>Finalizando programa com sucesso.");
                    return;

                default:
                    System.out.println("ERRO. Opção inválida. Tente novamente.1");
            }
        }
    }
}
