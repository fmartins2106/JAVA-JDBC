package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;

import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaProdutosComMap09 {
    public static Map<String, DadosProduto05> produtosCadastrados = new LinkedHashMap<>();

    public boolean addProduto(DadosProduto05 dadosProduto05){
        return produtosCadastrados.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    public boolean addProduto2(DadosProduto05 dadosProduto05){
        DadosProduto05 produto05 = produtosCadastrados.put(dadosProduto05.getNome(),dadosProduto05);
        if (produto05 != null){
            System.out.println("Nenhum produto foi cadastrado.");
            return false;
        }
        System.out.println("Produto cadastrado com sucesso.");
        return true;
    }

    public void addProduto3(DadosProduto05 dadosProduto05){
        if (produtosCadastrados.containsKey(dadosProduto05.getNome())){
            System.out.println("Produto já cadastrado. Tente novamente.");
            return;
        }
        produtosCadastrados.put(dadosProduto05.getNome(),dadosProduto05);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void getRelatorioEstoque(){
        if (produtosCadastrados.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtosCadastrados.entrySet().stream()
                .map(produto -> "Nome:"+produto.getKey()+" |Quantidade:"+produto.getValue().getQuantidade())
                .forEach(System.out::println);
    }

    public void getValorEstoque(){
        if (produtosCadastrados.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtosCadastrados.values().stream()
                .map(produtos -> "Nome:"+produtos.getNome()+" |Valor total em estoque:R$"+produtos.getQuantidade() * produtos.getPreco())
                .forEach(System.out::println);

    }

    public double getValorEstoque2(){
        return produtosCadastrados.values().stream()
                .mapToDouble(produtos -> produtos.getPreco() * produtos.getQuantidade())
                .sum();

    }



}
