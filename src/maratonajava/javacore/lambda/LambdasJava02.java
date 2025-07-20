package academy.devdojo.maratonajava.javacore.lambda;

import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase19;

import java.util.*;
import java.util.stream.Collectors;

public class LambdasJava02 {
    private static final Scanner scanner = new Scanner(System.in);
    public List<ProdutoBase19> produtoBase19s;

    public LambdasJava02(){
        this.produtoBase19s = new ArrayList<>();
    }

    private void removerProduto(){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        String nome = scanner.nextLine().trim();
        boolean produtoEncontrado = produtoBase19s.removeIf(produtoBase19 -> produtoBase19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private void listarProdutos(){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase19s.forEach(System.out::println);
    }

    private void pesquisaPorNome(){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        String nome = scanner.nextLine().trim();
        Optional<ProdutoBase19> produtoEncontrado = produtoBase19s.stream().filter(produtoBase19 -> produtoBase19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (produtoEncontrado.isPresent()){
            System.out.println("Produto(s) encontrados:");
            System.out.println(produtoEncontrado);
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    private void produtosMaior100Unidades(){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<ProdutoBase19> produtoEncontrado = produtoBase19s.stream().filter(produtoBase19 -> produtoBase19.getQuantidade() >= 100)
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void listarProdutosOrdenadosPorNome(){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produtoBase19s.stream().sorted(Comparator.comparing(ProdutoBase19::getNome))
                .forEach(System.out::println);
    }

    private void listarSomenteNomes(){
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produtoBase19s.stream().map(ProdutoBase19::getNome)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
