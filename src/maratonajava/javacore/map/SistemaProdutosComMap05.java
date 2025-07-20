package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto45;
import academy.devdojo.maratonajava.javacore.Interface.dominio.SistemaProdutos05;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaProdutosComMap05 {

    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, DadosProduto05> produto05Map = new LinkedHashMap<>();

    private boolean addProdutoCarrinho(DadosProduto05 dadosProduto05){
        if (produto05Map.containsKey(dadosProduto05.getNome())){
            System.out.println("Produto Já cadastrado.");
            return false;
        }
        return produto05Map.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    private boolean addProdutoMetodo2(DadosProduto05 dadosProduto05){
        DadosProduto05 addProduto = produto05Map.putIfAbsent(dadosProduto05.getNome(),dadosProduto05);
        if (addProduto != null){
            System.out.println("Produto:"+dadosProduto05.getNome()+" Já cadastrado.");
            return false;
        }
        System.out.println("Produto:"+ dadosProduto05.getNome()+" cadastrado com sucesso.");
        return true;
    }

    private boolean excluirProduto(String nome){
        return produto05Map.remove(nome) == null;
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

    private boolean alterarDados(String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        DadosProduto05 alteracao = produto05Map.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        });
        if (alteracao != null){
            System.out.println("Produto: "+nome+" alterado com sucesso.");
            return false;
        }
        System.out.println("Produto: "+nome+" não encontrado.");
        return true;
    }

    private void listarProdutos(){
        if (produto05Map.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto05Map.forEach((s, dadosProduto05) -> System.out.println(dadosProduto05));
    }

    private DadosProduto05 buscarPorNome(String nome){
        return produto05Map.get(nome);
    }

    public static void main(String[] args) {

        SistemaProdutosComMap05 sistemaProdutosComMap05 = new SistemaProdutosComMap05();
        sistemaProdutosComMap05.addProdutoMetodo2(new DadosProduto05("nome1",2,32,"aaaaa"));
        sistemaProdutosComMap05.addProdutoMetodo2(new DadosProduto05("nome2",3,52,"vvvvv"));
        sistemaProdutosComMap05.listarProdutos();
        sistemaProdutosComMap05.getQuantidadeTotalEstoque();
        System.out.println("Valor total em estoque:R$"+sistemaProdutosComMap05.getValorTotalEstoque());
    }

}
