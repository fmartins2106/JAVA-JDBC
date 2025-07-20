package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream08 {
    private List<Produto19> produto19s;

    public Stream08(){
        this.produto19s = new ArrayList<>();
    }

    public void excluirDados(String nome){
        produto19s.stream()
                .filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(produto19 -> {
                    produto19s.remove(produto19);
                    System.out.println("Produto removido com sucesso.");
                }, ()-> System.out.println("Nenhum produto foi encontrado."));
    }

    public void excluirProduto2(String nome){
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado. Verifique.");
    }

    public void pesquisaPorNome(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    public void pesquisaPorNome(String nome){
        produto19s.stream()
                .filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nome não encontrado."));
    }

    public void pesquisaEstoqueMais100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtosEncontrados =produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getQuantidade))
                .filter(produto19 -> produto19.getQuantidade() > 100)
                .toList();
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }

    public void listarSomenteNomeOrdenAfabetica(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .toList()
                .forEach(System.out::println);
    }

    public void listaOrdemAlfabetica(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .forEach(System.out::println);
    }

    public void listarNomesValoresTotais(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .map(produto19 -> "Nome:"+produto19.getNome()+" |Valor total em estoque:R$"+produto19.getValor()+produto19.getQuantidade())
                .forEach(System.out::println);
    }

    public void listarNomeValoresTotais2(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s
                .forEach(produto19 -> {
                    double total = produto19.getValor() * produto19.getQuantidade();
                    System.out.println("Nome:"+produto19.getNome()+" |Valor total em estoque:R$"+total);
                });
    }

    public void quantidadeMenor100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<Produto19> produtosMenos100Estoque = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() < 100)
                .toList();
        if (produtosMenos100Estoque.isEmpty()){
            System.out.println("Nenhum  produto encontrado.");
            return;
        }
        System.out.println(produtosMenos100Estoque);
    }

    public void faixaDePreco(double menorPreco, double maiorPreco){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<Produto19> produtoEncontrado = produto19s.stream()
                .filter(produto19 -> produto19.getValor() >= menorPreco && produto19.getValor() <= maiorPreco)
                .toList();
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    public void contarElementos(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        long contar = produto19s.stream()
                .distinct()
                .filter(produto19 -> produto19.getQuantidade() < 5)
                .count();
        System.out.println(contar);
    }

    private boolean pesquisaPorValor1(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getQuantidade() > 5);
    }

    private boolean pesquisaPorValor2(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getQuantidade() < 5);
    }

    private boolean pesquisaPorValor3(){
        return produto19s.stream().noneMatch(produto19 -> produto19.getQuantidade() < 0);
    }

    public void maiorValorFiltro(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getValor() > 5)
                .max(Comparator.comparing(Produto19::getValor))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nenhum produto foi encontrado9."));
    }

    public void maiorValoFiltro2(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade()  > 100)
                .max(Comparator.comparing(Produto19::getQuantidade))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nenhum produto foi encontrado."));
    }

    public void somarPrecosPorQuantidade(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        double soma = produto19s.stream().
                mapToDouble(produto19s -> produto19s.getQuantidade() * produto19s.getValor()).sum();
        System.out.println("Soma total de valores em estoque:R$"+soma);
    }

    public double somarPrecos(){
        return produto19s.stream().mapToDouble(Produto19::getValor).sum();
    }

    public void primeiroValorEncontrado(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getValor() > 5)
                .findFirst()
                .ifPresentOrElse(System.out::println,() -> System.out.println("Nenhum produto foi encontrado."));
    }


    public double somarPrecoFiltro(){
        return produto19s.stream()
                .mapToDouble(Produto19::getValor)
                .filter(produto19 -> produto19 < 5)
                .sum();
    }






}
