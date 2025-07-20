package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import javax.crypto.spec.PSource;
import java.util.*;
import java.util.stream.Collectors;

public class Stream05 {

    private List<Produto19> produto19s;

    public Stream05(){
        this.produto19s = new ArrayList<>();
    }

    private void removerProdutoSistema(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    private void pesquisaPorNome(String nome){
        Optional<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (produtoEncontrado.isPresent()){
            System.out.println(produtoEncontrado);
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    private void pesquisaPorNome2(String nome){
        Optional<Produto19> produtoEncontrado = produto19s.stream().
                filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        produtoEncontrado.ifPresentOrElse(produto19 -> System.out.println(produtoEncontrado),
                () -> System.out.println("Nenhum produto foi encontrado."));
    }

    private void produtoEstoqueMaior100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtosEncontrados = produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .collect(Collectors.toList());
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }

    private void listarSomenteNome(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }

    private void listarPorOrdemAlfabeticaZA(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome).reversed())
                .forEach(System.out::println);
    }

    private void listarSomenteNomeValores(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<String> produtoEncontrados = produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getValor))
                .map(produto19 -> "Produto:"+produto19.getNome()
                        +" |Valor tatal em estoque:"+(produto19.getValor() * produto19.getQuantidade()))
                .toList();
        produtoEncontrados.forEach(System.out::println);
    }

    private void listarSomenteValores(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .forEach(produto19 -> {
                    double valorTotal = produto19.getValor() * produto19.getQuantidade();
                    System.out.println("Produto:"+produto19.getNome()+" Valor total em estoque:R$"+valorTotal);
                });
    }

    private void listarProdutosCadastrados(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    private void produtosQuantidadeMenor100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getQuantidade() <= 100)
                .sorted(Comparator.comparing(Produto19::getNome).reversed())
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void produtosQuantidadeMenor100p2(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .filter(produto19 -> produto19.getQuantidade() <= 100)
                .map(produto19 -> "Produto:"+produto19.getNome()+" |Quantidade:"+produto19.getQuantidade()
                        +" |Preço:R$"+produto19.getValor())
                .forEach(System.out::println);

    }

    private void produtosQuantidadeMenor100p3(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<String> produtosEncontrados = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() < 100)
                .sorted(Comparator.comparing(Produto19::getNome))
                .map(produto19 -> "Produto:"+produto19.getNome()+" |Quantidade:"+produto19.getQuantidade()+" |Preço:R$"+produto19.getValor())
                .collect(Collectors.toList());
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto foi encotrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }

    private void contarElementos(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        long contar = produto19s.stream()
                .distinct()
                .filter(produto19 -> produto19.getValor() <=5)
                .count();
        System.out.println(contar);
    }

    private void pesquisaPorPreco(){
        boolean temMais9 = produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 9);
        boolean temMaiorQueZero = produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 0);
        boolean nenhumNumeroMenorZero = produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);

    }

    private void maiorValorFiltro(){
        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)
                .max(Comparator.comparing(Produto19::getValor)) // Busca o produto com o maior valor dentro do filtro
                .ifPresentOrElse(System.out::println, () ->
                        System.out.println("Nenhum produto foi encontrado."));

    }

    private void primeiroValorFiltro(){
        produto19s.stream().filter(produto19 -> produto19.getValor() < 3)
                .findFirst()
                .ifPresentOrElse(System.out::println, ()->
                        System.out.println("Não tem produto com valor menor que 3."));
    }

    private double somarPrecos(){
        return produto19s.stream()
                .mapToDouble(produto19s -> produto19s.getValor() * produto19s.getQuantidade())
                .sum();
    }

    private void somarPrecos2(){
        double somarPrecos = produto19s.stream()
                .mapToDouble(Produto19::getValor) // Pega só os valores (double) dos produtos
                .filter(aDouble -> aDouble < 3) // Filtra valores menores que 3
                .sum();// Soma todos esses valores filtrados

    }


    // Iniciando uso de Collections
    private void calculandoDiversasFormas() {
        // 🔥 Maior valor (forma 1)
        produto19s.stream()
                .max(Comparator.comparing(Produto19::getValor))
                .ifPresent(p -> System.out.println("Maior (forma 1): " + p));

        // 🔥 Maior valor (forma 2 usando Collectors)
        produto19s.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Produto19::getValor)))
                .ifPresent(p -> System.out.println("Maior (forma 2): " + p));


        // Soma dos valores (forma 1)
        double soma1 = produto19s.stream()
                .mapToDouble(Produto19::getValor)
                .sum();
        System.out.println("Soma (forma 1): " + soma1);

        // Soma dos valores (forma 2 usando Collectors)
        double soma2 = produto19s.stream()
                .collect(Collectors.summingDouble(Produto19::getValor));
        System.out.println("Soma (forma 2): " + soma2);


        // Média dos valores (forma 1)
        produto19s.stream()
                .mapToDouble(Produto19::getValor)
                .average()
                .ifPresent(avg -> System.out.println("Média (forma 1): " + avg));

        // Média dos valores (forma 2 usando Collectors)
        double media = produto19s.stream()
                .collect(Collectors.averagingDouble(Produto19::getValor));
        System.out.println("Média (forma 2): " + media);


        // Estatísticas completas (count, sum, min, max, average)
        DoubleSummaryStatistics stats = produto19s.stream()
                .collect(Collectors.summarizingDouble(Produto19::getValor));
        System.out.println("Estatísticas: " + stats);
        // Você pode acessar diretamente:
        System.out.println("→ Soma: " + stats.getSum());
        System.out.println("→ Média: " + stats.getAverage());
        System.out.println("→ Máximo: " + stats.getMax());
        System.out.println("→ Mínimo: " + stats.getMin());
        System.out.println("→ Quantidade: " + stats.getCount());


        // Lista dos nomes separados por vírgula
        String nomes = produto19s.stream()
                .map(Produto19::getNome)
                .collect(Collectors.joining(", "));
        System.out.println("Nomes: " + nomes);
    }





















}
