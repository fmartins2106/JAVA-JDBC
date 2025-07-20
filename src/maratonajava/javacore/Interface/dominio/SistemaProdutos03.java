package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeDadosProduto;

import java.util.*;

public class SistemaProdutos03 {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String,DadosProduto03> dadosProdutos = new LinkedHashMap<>();

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                DadosProduto03.validacaoNome(nome);
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
                DadosProduto03.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir preço.");
            }catch (PrecoDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                DadosProduto03.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para definir quantidade.");
            }catch (QuantidadeDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoDescricao(){
        while (true){
            try {
                System.out.print("Descrição:");
                String descricao = scanner.nextLine().trim();
                DadosProduto03.validacaoDescricao(descricao);
                return descricao;
            }catch (DescricaoProdutoDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean addProdutoSistema(DadosProduto03 dadosProduto03){
        return dadosProdutos.putIfAbsent(dadosProduto03.getNome(),dadosProduto03) == null;
    }

    public boolean atualizarProduto(String nome, double novoPreco, int novaquantidade, String novaDescricao){
        return dadosProdutos.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novoPreco);
            v.setQuantidade(novaquantidade);
            v.setDescricao(novaDescricao);
            return v;
        }) != null;
    }

    public boolean removerProduto(String nome){
        return dadosProdutos.remove(nome) == null;
    }

    public void listarProdutos(){
        if (dadosProdutos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        dadosProdutos.forEach((nome,dadosProdutos) -> System.out.println(nome+" =>"+dadosProdutos));
    }

    public DadosProduto03 buscarProduto(String nome){
        return dadosProdutos.get(nome);
    }

    public void gerarRelatorioEstoque(){
        dadosProdutos.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println(e.getKey()+" Quantidade:"+e.getValue().getQuantidade()));
    }

    public double calcularValorTotalEstoque(){
        return dadosProdutos.values().stream().mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
    }

    public Set<String> getNomeProdutos(){
        return dadosProdutos.keySet();
    }

    public Collection<DadosProduto03> getProdutos(){
        return dadosProdutos.values();
    }



}
