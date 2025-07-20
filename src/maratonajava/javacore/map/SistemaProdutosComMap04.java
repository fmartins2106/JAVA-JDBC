package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto19;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaProdutosComMap04 {

    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, DadosProduto05> produto05Map = new LinkedHashMap<>();

    private boolean addProdutoSistema(DadosProduto05 dadosProduto05){
        return produto05Map.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    private boolean removerProduto(String nome){
        return produto05Map.remove(nome) == null;
    }

    private boolean alterarDadosProduto(String nome, double novoPreco, int novaQuantidade, String novaDescrica){
        return produto05Map.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescrica);
            return v;
        }) != null;
    }

    private void listarProdutos(){
        if (produto05Map.isEmpty()){
            System.out.println("Produto não cadastrado.");
            return;
        }
        produto05Map.forEach((s, dadosProduto05) -> System.out.println(dadosProduto05));
    }

    private void getQuantidadeTotalEstoque(){
        produto05Map.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println("Produto:"+e.getKey()
                +" |Quantidade:"+e.getValue().getQuantidade()));
    }

    private double getValorTotalEstoque(){
        return produto05Map.values().stream()
                .mapToDouble(value -> value.getPreco() * value.getQuantidade()).sum();
    }

    private DadosProduto05 buscarPorNome(String nome){
        return produto05Map.get(nome);
    }
}
