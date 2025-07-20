package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream06 {
    private List<Produto19> produto19s;

    public Stream06(){
        this.produto19s = new ArrayList<>();
    }

    private void addProdutoLista(Produto19 produto19){
        produto19s.add(produto19);
        System.out.println("Produto adicionado com sucesso");
    }

    public void removerProdutoSistema(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println("Produto removido com sucesso.");
    }

    public void buscarPorNome(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(System.out::println, () ->
                        System.out.println("Nenhum produto foi encontrado."));
    }

    public void pesquisaPorEstoqueMaior100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<Produto19> produtosEncontrados = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() > 100)
                .collect(Collectors.toList());
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }

    public void listarSomenteNome(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }

    public void listarPorOrdemAlfabetica(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .forEach(System.out::println);
    }

    public void listarSomenteNomeEValoresTotaisEstoque(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .map(produto19 -> "Produto:"+produto19.getNome()
                        +" |Quantidade:"+produto19.getValor() * produto19.getValor())
                .toList()
                .forEach(System.out::println);
    }

    public void listarSomenteValores(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .map(produto19 -> "Produto:"+produto19.getNome()+"Valor total em estoque:R$"+produto19.getValor() * produto19.getQuantidade())
                .toList()
                .forEach(System.out::println);
    }

    public void listarSomenteValores2(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .forEach(produto19 -> { double valorTotal = produto19.getValor() * produto19.getQuantidade();
                    System.out.println("Produto:"+produto19.getNome()+" |Valor total em estoque:R$"+valorTotal);
                });
    }

    public void quantidadeMenor100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<Produto19> produtosEncontrados = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() < 100)
                .toList();
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
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
                .filter(produto19 -> produto19.getValor() <= 5)
                .count();
        System.out.println(contar);
    }

    private void pesquisaPorQuantidade(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        boolean maiorQue3 = produto19s.stream().anyMatch(produto19 -> produto19.getQuantidade() > 3);
        boolean maiorrQue3 = produto19s.stream().anyMatch(produto19 -> produto19.getQuantidade() > 3);
        boolean maiorQue0 = produto19s.stream().noneMatch(produto19 -> produto19.getQuantidade() < 0);

    }

    private void maiorValorFiltro(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)
                .max(Comparator.comparing(Produto19::getValor))
                .ifPresentOrElse(System.out::println, () ->
                        System.out.println("Nenhum produto foi encontrado."));
    }

    private void primeiroValorEncontrado(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream().filter(produto19 -> produto19.getValor() < 3)
                .findFirst()
                .ifPresentOrElse(System.out::println, ()->
                        System.out.println("Produto não encontrado."));
    }

    private double somarPrecos(){
        return produto19s.stream()
                .mapToDouble(Produto19::getValor).sum();
    }

    private double calcularValorTotalEstoque(){
        return produto19s.stream()
                .mapToDouble(produto19 -> produto19.getValor() * produto19.getQuantidade())
                .sum();
    }

    private void somarPrecos2(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        double somar = produto19s.stream()
                .mapToDouble(Produto19::getValor)
                .filter(produto19 -> produto19 < 3)
                .sum();
    }

    public static void main(String[] args) {
        Stream06 stream06 = new Stream06();
        Produto19 produto19 = new Produto19(1,"produto numero","categoria",22,11,122);
        Produto19 produto20 = new Produto19(2,"produto n","categoria A",33,112,1232);
        stream06.addProdutoLista(produto19);
        stream06.addProdutoLista(produto20);
        stream06.buscarPorNome("maria da silva");
        stream06.listarSomenteNomeEValoresTotaisEstoque();
        stream06.primeiroValorEncontrado();
    }
}
