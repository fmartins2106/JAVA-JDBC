package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosLogger05;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaProdutosComMap03 {
    private final Map<String, DadosProduto05> produto05Map = new LinkedHashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = ProdutosLogger05.getLogger(SistemaProdutosComMap03.class);
    private static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                DadosProduto05.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir preço.");
                logger.log(Level.WARNING,"Valor informado não é número."+e.getMessage());
            }catch (PrecoDadosProduto e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro de regra de negócio:"+e.getMessage());
            }
        }
    }

    private boolean addProdutoSistema(DadosProduto05 dadosProduto05){
        return produto05Map.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    private boolean removerProduto(String nome){
        return produto05Map.remove(nome) == null;
    }

    private DadosProduto05 buscaPorProduto(String nome){
        return produto05Map.get(nome);
    }

    private boolean alterarDadosProduto(String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        return produto05Map.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        }) != null;
    }

    private void listarProdutos(){
        if (produto05Map.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto05Map.forEach((nome, dadosProduto05) -> System.out.println(produto05Map));
    }

    private void getQuantidadeTotalEstoque(){
        produto05Map.entrySet().stream().sorted(Comparator.comparing(e-> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println("Produto:"+e.getKey()
                +" |Quantidade:"+e.getValue().getQuantidade()));
    }

    private double valorTotalEstoque(){
        return produto05Map.values().stream()
                .mapToDouble(e -> e.getQuantidade() * e.getPreco()).sum();
    }


}
