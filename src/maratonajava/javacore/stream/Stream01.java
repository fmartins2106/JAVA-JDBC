package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.*;
import java.util.stream.Collectors;

public class Stream01 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Produto19> produto19s;

    public Stream01(){
        this.produto19s = new ArrayList<>();
    }

    public void removerProduto(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        int codigo = Integer.parseInt(scanner.nextLine().trim());
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getCodigo() == codigo);
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private void listarProdutos(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    private void pesquisaPorNome(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        String nome = scanner.nextLine().trim();
        Optional<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (produtoEncontrado.isPresent()){
            System.out.println(produtoEncontrado);
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private void produtoMaior100Unidades(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<Produto19> produtosMai100 = produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .collect(Collectors.toList());
        if (!produtosMai100.isEmpty()){
            System.out.println(produtosMai100);
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    private void listarProdutosOrdenadosPorNome(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .forEach(System.out::println);
    }

    private void listarSomenteNomes(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produto19s.stream().map(Produto19::getNome).collect(Collectors.toList())
                .forEach(System.out::println);
    }

}

