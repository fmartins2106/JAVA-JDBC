package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaProdutosComMap07 {

    Map<String, DadosProduto05> dadosProdutosCadastrados = new LinkedHashMap<>();

    public boolean addProdutoSistema(DadosProduto05 dadosProduto05){
        return dadosProdutosCadastrados.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    public void addProdutosSistema2(DadosProduto05 dadosProduto05){
        boolean produtoAdicionado = dadosProdutosCadastrados.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
        if (!produtoAdicionado){
            System.out.println("Produto já cadastrado.");
            return;
        }
        System.out.println("Produto cadastrado com sucesso.");
    }

    public boolean addProdutosSistema3(DadosProduto05 dadosProduto05){
        DadosProduto05 produto = dadosProdutosCadastrados.putIfAbsent(dadosProduto05.getNome(),dadosProduto05);
        if (produto != null){
            System.out.println("Produto já cadastrado.");
            return false;
        }
        System.out.println("Produto cadastrado com sucesso.");
        return true;
    }

    public boolean removerProduto(String nome){
        return dadosProdutosCadastrados.remove(nome) != null;
    }

    public void removerProduto2(String nome){
        if (dadosProdutosCadastrados.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        boolean produtoRemovido = dadosProdutosCadastrados.remove(nome) != null;
        if (!produtoRemovido){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println("Produto removido com sucesso.");
    }

    public boolean alterarDadosProdutos(String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        return dadosProdutosCadastrados.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        }) !=null;
    }

    public void getRelatorioEstoque(){
        dadosProdutosCadastrados.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println("Nome:"+e.getKey()+" |Quantidade:"+e.getValue().getQuantidade()));
    }

    public double getValorTotalEstoque(){
        return dadosProdutosCadastrados.values()
                .stream()
                .mapToDouble(value -> value.getQuantidade() * value.getPreco())
                .sum();

    }


}
