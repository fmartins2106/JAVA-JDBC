package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto19;

import java.util.*;
import java.util.stream.Collectors;

public class Stream02 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Produto19> produto19s;

    public Stream02(){
        this.produto19s = new ArrayList<>();
    }

    public Stream02(List<Produto19> produto19s) {
        this.produto19s = produto19s;
    }

    private void removerProdutoSistema(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        String nome = scanner.nextLine().trim();
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    private void listarProdutos(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    private void buscarPorNome(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        Optional<Produto19> buscaPorNome = produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (buscaPorNome.isPresent()){
            System.out.println(buscaPorNome);
            return;
        }
        System.out.println("Nome de produto não cadastrado no sistema.");
    }

    private void produtoMaior100Unidades(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<Produto19> produtoMais100 = produto19s.stream().filter(produto19 -> produto19.getEstoque() > 100).
                collect(Collectors.toList());
        if (!produtoMais100.isEmpty()){
            System.out.println(produtoMais100);
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    private void listarProdutosListadosPorNome(){
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
        produto19s.stream().map(Produto19::getNome)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


}
