package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;
import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;

import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaProdutosComMap06 {
    private final Map<String, DadosProduto05> produtosSistema = new LinkedHashMap<>();

    public void  addProdutoSistema(DadosProduto05 dadosProduto05){
        if (produtosSistema.containsKey(dadosProduto05.getNome())){
            System.out.println("Chave inválida. Já consta no sistema.");
            return;
        }
        produtosSistema.put(dadosProduto05.getNome(),dadosProduto05);
    }

    public boolean addProdutoSistema2(DadosProduto05 dadosProduto05){
        DadosProduto05 addProduto = produtosSistema.putIfAbsent(dadosProduto05.getNome(),dadosProduto05);
        if (addProduto != null){
            System.out.println("Chave inválida. Já consta no sistema.");
            return false;
        }
        System.out.println("Produto adicionado no sistema com sucesso");
        return true;
    }

    public boolean excluirProdutoSistema(DadosProduto05 dadosProduto05){
        return produtosSistema.remove(dadosProduto05.getNome(),dadosProduto05);
    }

    public boolean alterarDadosProduto(String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        return produtosSistema.computeIfPresent(nome,(chave,dadosProduto) ->{
            dadosProduto.setPreco(novoPreco);
            dadosProduto.setQuantidade(novaQuantidade);
            dadosProduto.setDescricao(novaDescricao);
            return dadosProduto;
        }) != null;
    }

    public void getQuantidadeTotalEstoque(){
        produtosSistema.entrySet()
                .stream()
                .map(dadosProduto -> "Chave:"+dadosProduto.getKey()+" |Quantidade Total: "+dadosProduto.getValue().getQuantidade())
                .forEach(System.out::println);
    }

    public double getValorTotalEstoque(){
        return produtosSistema.values()
                .stream()
                .mapToDouble(dadosProduto05 -> dadosProduto05.getPreco() * dadosProduto05.getQuantidade())
                .sum();
    }

    private DadosProduto05 buscarPorProduto(String nome){
        return produtosSistema.get(nome);
    }

}



