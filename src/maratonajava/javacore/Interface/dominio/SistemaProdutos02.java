package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeDadosProduto;

import java.util.*;

public class SistemaProdutos02 {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String,DadosProduto02> produtos = new HashMap<>();

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                DadosProduto02.validacaoNome(nome);
                return nome;
            }catch (NomeDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                DadosProduto02.validacaoPreco(preco);
                return preco;
            }catch (PrecoDadosProduto e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir preço.");
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                DadosProduto02.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir quantidade.");
            }catch (QuantidadeDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoDescricao(){
        while (true){
            try {
                System.out.print("Descricao:");
                String descricao = scanner.nextLine().trim();
                DadosProduto02.validacaoDescricao(descricao);
                return descricao;
            }catch (DescricaoProdutoDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean addProdutosSistema(DadosProduto02 dadosProduto02){
        return produtos.putIfAbsent(dadosProduto02.getNome(), dadosProduto02) == null;
    }

    public boolean atualizarProduto(String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        return produtos.computeIfPresent(nome,(k,v) -> {
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        }) != null;
    }

    public boolean removerProduto(String nome){
        return produtos.remove(nome) != null;
    }

    public void listarProdutos(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtos.forEach((nome,produtos) -> System.out.println(nome + " =>" + produtos));
    }

    public DadosProduto02 buscarProduto(String nome){
        return produtos.get(nome);
    }

    public void gerarRelatorioEstoque(){
        produtos.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println(e.getKey() +" Quantidade:"+e.getValue().getQuantidade()));
    }

    public double calcularValorTotalEstoque(){
        return produtos.values().stream().mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
    }

    public Set<String> getNomesProdutos(){
        return produtos.keySet();
    }

    public Collection<DadosProduto02> getProdutos(){
        return produtos.values();
    }

    public Set<Map.Entry<String, DadosProduto02>> getEntradas(){
        return produtos.entrySet();
    }

}
