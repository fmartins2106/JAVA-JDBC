package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;

import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaProdutosComMap08 {
    private static Map<String, DadosProduto05> dadosCadastroProdutos = new LinkedHashMap<>();

    public boolean addProdutoSistema(DadosProduto05 dadosProduto05){
        return dadosCadastroProdutos.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    public boolean addProdutoSistema2(DadosProduto05 dadosProduto05){
        if (dadosCadastroProdutos.containsKey(dadosProduto05.getNome())){
            System.out.println("Operação inválida, produto já cadastrado.");
            return false;
        }
        dadosCadastroProdutos.put(dadosProduto05.getNome(),dadosProduto05);
        System.out.println("Produto cadastrado com sucesso.");
        return true;
    }

    public boolean addProdutolsSistema3(DadosProduto05 dadosProduto05){
        DadosProduto05 dadosProduto6 = dadosCadastroProdutos
                .putIfAbsent(dadosProduto05.getNome(),dadosProduto05);
        if (dadosProduto6 != null){
            System.out.println("Produto já cadastrado.");
            return false;
        }
        System.out.println("Produto cadastrado com sucesso.");
        return true;
    }

    public void getRelatorioEstoque(){
        dadosCadastroProdutos.entrySet().stream()
                .map(produto -> "Produto:"+produto.getKey()+" |Estoque:"+produto.getValue().getQuantidade())
                .toList()
                .forEach(System.out::println);
    }

    public double getValorEstoque(){
        return dadosCadastroProdutos.values().stream()
                .mapToDouble(produto -> produto.getPreco() * produto.getQuantidade())
                .sum();
    }

    public void removerProduto(String nome){
        dadosCadastroProdutos.entrySet().stream()
                .filter(produtos -> produtos.getValue().getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(dadosProdutos -> {
                    dadosCadastroProdutos.remove(dadosProdutos.getKey(),dadosProdutos.getValue());
                    System.out.println("Prooduto removido com sucesso.");
                }, () -> System.out.println("Produto não encontrado."));
    }

    public void removerProduto2(String nome){
        boolean produtoEncontrado = dadosCadastroProdutos.entrySet()
                .removeIf(dadosProduto05Entry ->
                        dadosProduto05Entry.getKey().equalsIgnoreCase(nome));
        if (!produtoEncontrado){
            System.out.println("Produto não encontrado.");
            return;
        }
        System.out.println("Produto removido com sucesso.");
    }

    public boolean alterarDadosProdutos(String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        return dadosCadastroProdutos.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        })!= null;
    }






}
