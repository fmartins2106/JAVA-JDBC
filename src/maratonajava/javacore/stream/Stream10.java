package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produtos19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Stream10 {

    private List<Produto19> produto19s;

    public Stream10(){
        this.produto19s = new ArrayList<>();
    }

    public void excluirProduto(String nome){
         boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println("Produto removido com sucesso.");
    }

    public void excluirProduto2(int codigo){
        produto19s.stream()
                .filter(produto19 -> produto19.getCodigo() ==  codigo).findFirst()
                .ifPresentOrElse(produto19 -> {
                    produto19s.remove(produto19);
                    System.out.println("Produto removido com sucesso");
                }, () -> System.out.println("Produto não encontrado"));
    }

    public void pesquisaPorNome(String nome){
        produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Produto não encontrado."));
    }

    public void pesquisaPorNome2(String nome){
        produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .forEach(System.out::println);
    }

    public void pesquisaEstoqueMais100(){
        produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .forEach(System.out::println);
    }

    public void pesquisaEstoqueMais1002(){
        List<Produto19> produtosEncontrados = produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .toList();
        if (produtosEncontrados.isEmpty()) {
            System.out.println("Produtos não encontrados.");
            return;
        }
        System.out.println(produtosEncontrados);
    }


    public void listaProtudosPorOrdemAlfabetica(){
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .forEach(System.out::println);
    }

    public void listarSomenteNomes(){
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }

    public void listarSomenteNomeEValoresProdutos(){
        produto19s.stream()
                .map(produto19 -> "Nome:"+ produto19.getNome()+" |Valores:R$"+produto19.getValor())
                .forEach(System.out::println);
    }

    public void listarSomenteNomeValoresTotaisEstoque(){
        produto19s.stream()
                .map(produto19 -> "Produto:"+produto19.getNome()+" |Valor total estoque:R$"+produto19.getValor() * produto19.getQuantidade())
                .forEach(System.out::println);
    }

    public void listarSomenteNomeValoresTotaisEstoque2(){
        produto19s.forEach(produto19 -> {
                    double total = produto19.getValor() * produto19.getQuantidade();
                    System.out.println("Produto:"+produto19.getNome()+" Total:R$"+total);
                });
    }

    public void quantidadeMenor100(){
        produto19s.stream().filter(produto19 -> produto19.getQuantidade() < 100)
                .forEach(System.out::println);
    }

    public void quantidadeMenor1002(){
        List<Produto19> produtosMenor100 = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() < 100)
                .toList();
        if (produtosMenor100.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosMenor100);
    }

    public void pesquisaPorFaixaDePreco(double menorPreco, double maiorPreco){
        List<Produto19>  produtosFaixaPreco = produto19s.stream()
                .filter(produto19 -> produto19.getValor() >= menorPreco && produto19.getValor() <= maiorPreco)
                .toList();
        if (produtosFaixaPreco.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosFaixaPreco);
    }

    public void contarElementos(){
        Long contarElementos = produto19s.stream()
                .distinct()
                .count();
        System.out.println(contarElementos);
    }

    public void contarProdutosPrecoMenor5(){
        Long contar = produto19s.stream()
                .filter(produto19 -> produto19.getValor() < 5)
                .count();
        System.out.println(contar);
    }

    public void pesquisaPorValor(){
        produto19s.stream().filter(produto19 -> produto19.getValor() < 5)
                .findFirst().ifPresentOrElse(System.out::println,
                        () -> System.out.println("Produto não encontrado."));
    }

    public boolean produtoEncontrado2(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 8);
    }

    public boolean produtoEncontado3(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getValor() < 5);
    }

    public boolean produtoEncontrado4(){
        return produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);
    }

    public void maiorValorFiltro(){
        produto19s.stream()
                .filter(produto19 -> produto19.getValor() > 5)
                .max(Comparator.comparing(Produto19::getValor))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Produto não encontrado."));
    }

}
