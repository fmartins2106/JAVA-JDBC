package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stream12 {
    private List<Produto19> produto19s;

    public Stream12(){
        this.produto19s = new ArrayList<>();
    }

    public void addProduto(Produto19 produto19){
        produto19s.add(produto19);
    }

    public void excluirDadosSistema(String nome){
        produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst()
                .ifPresentOrElse(produto19 -> {
                    produto19s.removeIf(produto20 -> produto19.getNome().equalsIgnoreCase(nome));
                    System.out.println("Produto removido do sistema com sucesso.");
                }, () -> System.out.println("Produto não encontrado."));
    }

    public void removerProduto(String nome){
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (!produtoEncontrado){
            System.out.println("Produto não encontrado.");
            return;
        }
        System.out.println("Produtuo removido do sistema com sucesso.");
    }

    public void listaProdutoEstoqueMaior100(){
        List<Produto19> produtosEncontrados = produto19s.stream().filter(produto19 -> produto19.getQuantidade() >= 100)
                .toList();
        if (produtosEncontrados.isEmpty()){
            System.out.println("Produto não encontrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }


    public void listaProdutoEstoqueMaior1002(){
        produto19s.stream().filter(produto19 -> produto19.getQuantidade() >= 100)
                .toList().forEach(System.out::println);
    }

    public void listaProdutoEstoqueMaior1003(){
        produto19s.stream().filter(produto19 -> produto19.getQuantidade() >= 100)
                .forEach(System.out::println);
    }

    public void produtosPorOrdemAlfabetica(){
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .forEach(System.out::println);
    }

    public void listarSomenteNomes(){
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }

    public void listarSomenteNomeValoresProduto(){
        produto19s.stream().map(produto19 -> "Produto:"+produto19.getNome()+" |Valor:R$"+produto19.getValor())
                .forEach(System.out::println);
    }
    
    public void listarSomenteNomeValores2(){
        produto19s.forEach(produto19 -> System.out.println("Produto:"+produto19.getNome()+" |Valor:R$"+produto19.getValor()));
    }

    public void listarSomenteNomeValoresTotaisEstoque(){
        produto19s.forEach(produto19 -> System.out.println("Nome:"+produto19.getNome()+" |Valor total em estoque:R$"+
                produto19.getValor() * produto19.getQuantidade()));
    }

    public void quantidadeMenor100(){
        produto19s.stream().filter(produto19 -> produto19.getQuantidade() < 100)
                .forEach(System.out::println);
    }

    public void pesquisaPorFaixaDePreco(double menorpreco, double maiorPreco){
        produto19s.stream()
                .filter(produto19 -> produto19.getValor() >= menorpreco && produto19.getValor() <= maiorPreco)
                .forEach(System.out::println);
    }

    public void contarElementos(){
         Long contagem =  produto19s
                .stream()
                .distinct()
                .count();
        System.out.println(contagem);
    }

    public void contarProdutosValorMenorQue5(){
        Long contagemMenor5 = produto19s
                .stream()
                .filter(produto19 -> produto19.getValor() < 5)
                .count();
        System.out.println(contagemMenor5);
    }

    public void contarProdutoValorMenor5(){
        boolean encontrado = produto19s.stream().anyMatch(produto19 -> produto19.getValor() < 5);
    }

    public boolean contarProdutosValorMaior5(){
        return produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 6);
    }

    public boolean valoresMenorQueZero(){
        return produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);
    }

    public void maiorValorFiltro(){
        produto19s.stream().filter(produto19 -> produto19.getValor() > 100)
                .max(Comparator.comparing(Produto19::getValor))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Produto não encontrado."));
    }

    public static void main(String[] args) {
        Stream12 stream12 = new Stream12();
        Produto19 produto19 = new Produto19(1,"pipoca caramelizada","eletronico",23.33,2222,2000);
        stream12.addProduto(produto19);
        Produto19 produto22 = new Produto19(2,"cachorro quente","alimento saudavel",3.33,2222,4000);
        stream12.addProduto(produto22);
        stream12.listaProdutoEstoqueMaior100();
        System.out.println("_____________________________");
        stream12.listaProdutoEstoqueMaior1002();
        System.out.println("_____________________________");
        stream12.listaProdutoEstoqueMaior1003();
        System.out.println("_____________________________");
        stream12.listarSomenteNomeValoresProduto();
    }
}