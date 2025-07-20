package academy.devdojo.maratonajava.javacore.lambda;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Estoque19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutoBase19;

import java.util.*;
import java.util.stream.Collectors;

public class LambdasJava {
    private static final Scanner scanner = new Scanner(System.in);
    public List<ProdutoBase19> produtos;

    private LambdasJava(){
        this.produtos = new ArrayList<>();
    }

    public static void main(String[] args) {
        LambdasJava lambdasJava = new LambdasJava();
        ProdutoBase19 produtoBase19 = new ProdutoBase19("carro",22,200,199);
        ProdutoBase19 produtoBase20 = new ProdutoBase19("moto",22,200,199);
        lambdasJava.addProduto(produtoBase20);
        lambdasJava.addProduto(produtoBase19);
    }

    private void addProduto(ProdutoBase19 produtoBase19){
         produtos.add(produtoBase19);
    }

    private void removerProduto(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        String nome = scanner.nextLine().trim();
        boolean produtoEncontrado = produtos.removeIf(produtoBase19 -> produtoBase19.getNome().equals(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private void removerProdutos(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        String nome = scanner.nextLine().trim();
        boolean produtoEncontrado = produtos.removeIf(produtoBase19 -> produtoBase19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }


    private void pesquisaPorNome(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        String nome = scanner.nextLine().trim();
        Optional<ProdutoBase19> produtoBase = produtos.stream().filter(produtoBase19 -> produtoBase19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (produtoBase.isPresent()){
            System.out.println("Produto encontrado.");
            System.out.println(produtoBase);
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void pesquisasPorNome(){
        if (produtos.isEmpty()){           System.out.println("Produto não encontrado.");
            return;
        }
        String nome = scanner.nextLine().trim();
        Optional<ProdutoBase19> nomeProduto = produtos.stream().filter(produtoBase19 -> produtoBase19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (nomeProduto.isPresent()){
            System.out.println(nomeProduto);
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private void listarProdutos(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtos.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtos.forEach(System.out::println);
    }

    private void produtosMaiorQue100(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase19> produtoBase19s = produtos.stream().filter(produtoBase19 -> produtoBase19.getQuantidade() >= 100 )
                .collect(Collectors.toList());
        if (produtoBase19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produtoBase19s.forEach(System.out::println);
    }

    public void produtosComEstoqueAcima100(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase19> produtosEncontrados = produtos.stream().filter(produtoBase19 -> produtoBase19.getQuantidade() >= 100)
                .collect(Collectors.toList());
        if (produtosEncontrados.isEmpty()){
            System.out.println("Produto não encontrado.");
            return;
        }
        produtos.forEach(System.out::println);
    }


    private void listarNomesProdutoPorOrdem(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtos.stream().sorted(Comparator.comparing(ProdutoBase19::getNome))
                .forEach(System.out::println);
    }

    public void listarNomesPorOrder(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produtos.stream().sorted(Comparator.comparing(ProdutoBase19::getNome))
                .forEach(System.out::println);
    }

    private void listarSomenteNome(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtos.stream().map(ProdutoBase19::getNome)
                .forEach(System.out::println);
    }

    public void listarSomenteOsNomes(){
        if (produtos.isEmpty()){
            System.out.println("Nenhuma lista cadastrada.");
            return;
        }
        produtos.stream().map(ProdutoBase19::getNome).collect(Collectors.toList())
                .forEach(System.out::println);
    }


}
