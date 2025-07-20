package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto11;

import java.util.*;

public class ProdutoTest11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto11> produto11s = new ArrayList<>();
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro de produto.");
            System.out.println("[2] Relatório produtos cadastrados.");
            System.out.println("[3] Alterar cadastro produto.");
            System.out.println("[4] Excluir produto cadastrado.");
            System.out.println("[5] Relatório produtos por preço.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    String nome = Produto11.validandoNome(scanner);
                    double valor = Produto11.validandoValor(scanner);
                    String categoria = Produto11.validandoCategoria(scanner);
                    Produto11 produto11 = new Produto11(nome,valor,categoria);
                    produto11s.add(produto11);
                    break;

                case 2:
                    if (produto11s.isEmpty()){
                        System.out.println("Lista vazia, cadastre produtos.");
                    }else {
                        for (int i = 0; i < produto11s.size(); i++) {
                            Produto11 produtos = produto11s.get(i);
                            produtos.tabelaProdutos(i, produto11s.size());
                        }
                    }
                    break;

                case 3:
                    if (produto11s.isEmpty()){
                        System.out.println("Lista vazia, cadastre produtos.");
                    }else {
                        try {
                            System.out.print("Digite codigo do produto:");
                            int codigo = Integer.parseInt(scanner.nextLine());
                            if (codigo < 0 || codigo >= produto11s.size()){
                                System.out.println("ERRO. Digite um código de matricula válido.");
                            }else {
                                Produto11 produtos = produto11s.get(codigo);
                                produtos.setNome(Produto11.validandoNome(scanner));
                                produtos.setValor(Produto11.validandoValor(scanner));
                                produtos.setCategoria(Produto11.validandoCategoria(scanner));
                            }
                        }catch (NumberFormatException e){
                            System.out.println("ERRO. Digite uma opção válida.");
                        }
                    }
                    break;

                case 4:
                    if (produto11s.isEmpty()){
                        System.out.println("Lista vazia, cadastre um produto.");
                    }else {
                        try {
                            for (int i = 0; i < produto11s.size(); i++) {
                                Produto11 produto = produto11s.get(i);
                                produto.tabelaProdutos(i,produto11s.size());
                            }
                            System.out.print("Digite o codigo do produto:");
                            int codigo = Integer.parseInt(scanner.nextLine());
                            if (codigo < 0 || codigo >= produto11s.size()){
                                System.out.println("Digite um código válido. Tente novamente.");
                            }else {
                                Produto11 produtos = produto11s.remove(codigo);
                            }
                        }catch (NumberFormatException e){
                            System.out.println("ERRO. Digite um código válido. Tente novamente.");
                        }
                    }
                    break;

                case 5:
                    if (produto11s.isEmpty()){
                        System.out.println("Lista vazia. Cadastre produtos.");
                    }else {
                        ArrayList<Produto11> cloneList = new ArrayList<>();
                        for (Produto11 produto : produto11s){
                            cloneList.add(produto.clone());
                        }
                        Collections.sort(cloneList, Comparator.comparingDouble(Produto11::getValor).reversed());
                        for (int i = 0; i < cloneList.size(); i++) {
                            Produto11 produtos = cloneList.get(i);
                            produtos.tabelaProdutos(i,cloneList.size());
                        }
                    }
                    break;

                case 6:
                    System.out.println(">>>Finalizando o programa<<<");
                    return;
                default:
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
            }
        }
    }
}
