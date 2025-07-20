package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream09 {

    private List<Produto19> produto19s;

    public Stream09(){
        this.produto19s = new ArrayList<>();
    }

    private void excluirDados(String nome){
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

    private void excluirProduto2(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(
                        produto19 -> {
                            produto19s.remove(produto19);
                            System.out.println("Produto removido com sucesso:");
                }, () -> System.out.println("Nenhum produto foi encontrado."));
    }

    public void pesquisaPorNome(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Nenhum produto foi encontrado."));
    }

    public void pesquisaPorNome2(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .forEach(System.out::println);
    }

    public void pesquisaEstoqueMais100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtosMais100 = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() > 100)
                .toList();
        if (produtosMais100.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosMais100);
    }

    public void pesquisaEstoqueMais1002(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() >= 100)
                .forEach(System.out::println);
    }


    public void listarProdutosPorOrdemAlfabetica(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .forEach(System.out::println);
    }

    public void listarSomenteNomes(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }


    public void  addProduto(Produto19 produto19){
        produto19s.add(produto19);
    }

    public void listarSomenteNomesEValores(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .map(produto19 -> "Nome:"+produto19.getNome()+" |Preço:R$"+produto19.getValor())
                .forEach(System.out::println);
    }

    public void listarSomenteNomesValoresTotais(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.forEach(produto19 -> {
            double total = produto19.getValor() * produto19.getQuantidade();
            System.out.println("Produto:"+produto19.getNome()+"Total:R$"+total);
        });
    }

    public void quantidadeMenor100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtosMenor100 = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() < 100)
                .toList();
        if (produtosMenor100.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosMenor100);
    }

    public void pesquisaPorFaixaDePreco(double menorPreco, double Maiorpreco){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtosNaFaixaPreco = produto19s.stream()
                .filter(produto19 -> produto19.getValor() >= 5 && produto19.getValor() <= 10)
                .toList();
        if (produtosNaFaixaPreco.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosNaFaixaPreco);
    }

    public void contarElementos(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        long contar = produto19s.stream()
                .distinct()
                .filter(produto19 -> produto19.getQuantidade() < 5)
                .count();
        System.out.println(contar);
    }

    public boolean pesquisaPorValor(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 5);
    }

    public boolean pesquisaPorValor2(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getValor() < 5);
    }

    public boolean pesquisaPorValor3(){
        return produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);
    }

    public void maiorValorFiltro(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getValor() < 5)
                .max(Comparator.comparing(Produto19::getValor))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nenhum produto foi encontrado."));
    }




    public static void main(String[] args) {
        Stream09 stream09 = new Stream09();
        List<Produto19> produtos = new ArrayList<>(List.of(
           new Produto19(1,"nome nome","dsdsdsd sdsd",22,111,111))
        );

        Produto19 produto19 = new Produto19(1,"nome nome","dsdsdsd sdsd",22,111,111);
        Produto19 produto20 = new Produto19(2,"nome nome nome","dsdsdsd sdsd",33,122,333);
        stream09.addProduto(produto19);
        stream09.addProduto(produto20);
        stream09.listarSomenteNomes();
        stream09.listarSomenteNomesEValores();
        stream09.contarElementos();
    }




}
