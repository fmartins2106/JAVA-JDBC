package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream04 {

    private List<Produto19> produto19s;

    public Stream04(){
        this.produto19s = new ArrayList<>();
    }

    private void listarProdutosCadastrados(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    private void excluirProduto(String nome){
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado) {
            System.out.println("Produto excluido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado com nome"+nome);
    }

    private void pesquisaPorNome2(String nome){
        Optional<Produto19> produtoEncontrado =  produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        produtoEncontrado.ifPresentOrElse(produto19 -> System.out.println("Produto encontrado:"+produto19)
        ,() -> System.out.println("Produto não encontrado."));
    }

    private void listaDeNomesEmOrdem(){
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }

    private void listarNomesProdutos(){
        produto19s.stream().map(Produto19::getNome)
                .toList()
                .forEach(System.out::println);
    }

    private void produtoMais100Unidades(){
        List<Produto19> produtosEncontrados = produto19s.stream().filter(produto19 -> produto19.getQuantidade() < 100)
                .collect(Collectors.toList());
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }

    private void produtosPorOrdemAlfabetica(){
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .forEach(System.out::println);
    }

    private void produtoQuantidadeMenor100(){
        List<Produto19> produtoEncontrado = produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .filter(produto19 -> produto19.getQuantidade() <=100)
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void listarQuantidadeMenor100(){
        List<String> produtoEncontrado = produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .filter(produto19 -> produto19.getQuantidade() <= 100)
                .limit(50)
                .map(Produto19::getNome)
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void contarElementos(){
        long contar = produto19s.stream()
                .distinct()
                .filter(produto19 -> produto19.getValor() <= 5)
                .count();
        System.out.println(contar);
    }

    private void pequisaPorPreco(){
        boolean temMaiorQue9 = produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 9);
        boolean temMaoirQue0 = produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 0);
        boolean nenhumMenorque0 = produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);
    }

    private void maiorValorFiltro(){
        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)
                .max(Comparator.comparing(Produto19::getValor)) // Busca o produto com o maior valor dentro do filtro
                .ifPresentOrElse(System.out::println, () ->
                        System.out.println("Produto não encontrado."));
    }

    private void retornarPrimeiroMaiorValor(){
        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)
                .findFirst() // filtra e traz somente o primeiro valor maior que 3.
                .ifPresentOrElse(System.out::println, () ->
                        System.out.println("Produto não encontrado."));
    }

    private void somarPrecos(){
        double somarValores = produto19s.stream()
                .mapToDouble(Produto19::getValor) // Pega só os valores (double) dos produtos
                .filter(value -> value < 3) // Filtra valores menores que 3
                .sum(); // Soma todos esses valores filtrados
    }





}
