package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;

import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaProdutosComMap10 {
    public final Map<String,DadosProduto05> produtosCadastrados = new LinkedHashMap<>();

    public boolean addProdutoSistema(DadosProduto05 dadosProduto05){
        return produtosCadastrados.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    public void addProdutoSistema2(DadosProduto05 dadosProduto05){
        boolean produto = produtosCadastrados.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
        if (!produto){
            System.out.println("Produto já cadastrado. Verifique.");
            return;
        }
        System.out.println("Produto cadastrado com sucesso.");
    }

    public boolean addProdutoSistema3(DadosProduto05 dadosProduto05){
        if (produtosCadastrados.containsKey(dadosProduto05.getNome())){
            System.out.println("Produto já cadastrado.");
            return false;
        }
        produtosCadastrados.put(dadosProduto05.getNome(),dadosProduto05);
        System.out.println("Produto cadastrado com sucesso.");
        return true;
    }

    public void relatorioProdutos(){
        if (produtosCadastrados.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtosCadastrados.forEach((nome, dadosProduto) -> System.out.println("Nome:"+nome+" |Dados produto:"+dadosProduto));
    }

    public void getRelatorioEstoque(){
        produtosCadastrados.entrySet().stream()
                .map(produtosCadastrados -> "Nome:"+produtosCadastrados.getKey()+" |Quantidade:"+
                        produtosCadastrados.getValue().getQuantidade())
                .forEach(System.out::println);
    }

    public void getRelatorioValorEstoqueProProduto(){
        produtosCadastrados.entrySet().stream()
                .map(produto -> "Produto:"+produto.getKey()+" |Valor total estoque:R$"+
                        produto.getValue().getQuantidade() * produto.getValue().getPreco())
                .forEach(System.out::println);
    }

    public double getValorTotalEstoque(){
        return produtosCadastrados.values().stream()
                .mapToDouble(produto -> produto.getPreco() * produto.getQuantidade())
                .sum();
    }


    public static void main(String[] args) {
        DadosProduto05 dadosProduto05 = new DadosProduto05("cachorro quente",2.32,222,"sdsdsdsdsd");
        DadosProduto05 dadosProduto06 = new DadosProduto05("Prato feito",5.32,412,"sdsdsdsdsd");
        DadosProduto05 dadosProduto07 = new DadosProduto05("Hamburguer",4.32,112,"sdsdsdsdsd");
        SistemaProdutosComMap10 sistemaProdutosComMap10 = new SistemaProdutosComMap10();
        sistemaProdutosComMap10.addProdutoSistema2(dadosProduto06);
        sistemaProdutosComMap10.addProdutoSistema3(dadosProduto05);
        sistemaProdutosComMap10.addProdutoSistema3(dadosProduto07);
        System.out.println("____________________________________________");
        double totalEstoque = sistemaProdutosComMap10.getValorTotalEstoque();
        System.out.println(totalEstoque);
        System.out.println("____________________________________________");
        sistemaProdutosComMap10.getRelatorioValorEstoqueProProduto();
    }


}
