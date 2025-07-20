package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream11 {

    private List<Produto19> produto19s;

    public Stream11(){
        this.produto19s = new ArrayList<>();
    }

    public void excluirProduto(String nome){
        boolean produtoEncontrado = produto19s
                .removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (!produtoEncontrado){
            System.out.println("Produto não encontrado. Tente novamente.");
            return;
        }
        System.out.println("Produto removido com sucesso.");
    }

    public void pesquisaPorNome(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Produto não encontrado."));
    }

    public void pesquisaEstoqueMaior100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .forEach(System.out::println);
    }

    public void produtosPorOrdemAlfabetica(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .forEach(System.out::println);
    }

    public void listarSomenteNomes(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }

    public void listarSomenteNomeValoresProdutos(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.forEach(produto19 -> System.out.println("Nome:"+produto19.getNome()+" |Preço:R$"+produto19.getValor()));
    }

    public void listarSomenteNomeValoresTotaisEstoque(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.forEach(produto19 -> System.out.println("Nome:"+produto19.getNome()+" |Preço:R$"+produto19.getValor() * produto19.getQuantidade()));
    }

    public void quantidadeMenor100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.stream().filter(produto19 -> produto19.getQuantidade() < 100)
                .forEach(System.out::println);
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getValor() >= precoMinimo && produto19.getValor() <= precoMaximo)
                .forEach(System.out::println);
    }

    public void contarElementosLista(){
        Long conta = produto19s.stream().distinct()
                .count();
        System.out.println(conta);
    }

    public void contarProdutosValorMenor5(){
        Long conta = produto19s.stream()
                .filter(produto19 -> produto19.getValor() < 5)
                .count();
        System.out.println(conta);
    }

    public void pesquisaPorValorMenor5(){
        produto19s.stream().filter(produto19 -> produto19.getValor() < 5)
                .findFirst()
                .ifPresentOrElse(System.out::println,() -> System.out.println("Produto não encontrado."));
    }

    public boolean produtoEncontradoPorValor1(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getValor() < 5);
    }

    public boolean produtoEncontradoPorValor2(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 5);
    }

    public boolean produtoEncontradoPorValor3(){
        return produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);
    }

    public void maiorValorFiltro(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum nome foi encontrado.");
            return;
        }
        produto19s.stream().filter(produto19 -> produto19.getValor() > 5)
                .max(Comparator.comparing(Produto19::getValor))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Produto não encontrado."));
    }

    public void addProduto(Produto19 produto19){
        produto19s.add(produto19);
    }

    public static void main(String[] args) {
        Produto19 produto19 = new Produto19(1,"Fernando Martins","ssssss",2.32,323,100);
        Stream11 stream11 = new Stream11();
        stream11.addProduto(produto19);
        stream11.listarSomenteNomes();
    }


}
