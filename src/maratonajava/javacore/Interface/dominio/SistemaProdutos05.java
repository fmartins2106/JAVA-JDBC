package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaProdutos05 {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, DadosProduto05> produtosCadastrados = new LinkedHashMap<>();
    private static final Logger logger = ProdutosLogger05.getLogger(SistemaProdutos05.class);

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                DadosProduto05.validacaoNome(nome);
                return nome;
            }catch (NomeDadosProduto e){
                System.out.println("Erro, campo nome não pode conter caracteres ou ser vazio.");
                logger.log(Level.WARNING,"Erro de regra de negócio:"+e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                DadosProduto05.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro, valor inválido.");
                logger.log(Level.WARNING,"valor inválido."+e.getMessage());
            }catch (PrecoDadosProduto e){
                logger.log(Level.WARNING,"Erro de regra de negócio."+e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                DadosProduto05.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro, digite um número válido.");
                logger.log(Level.WARNING,"Erro, digite um valor válido."+e.getMessage());
            }
        }
    }

    public static String validandoDescricao(){
        while (true){
            try {
                System.out.println("Descrição:");
                String descricao = scanner.nextLine().trim();
                DadosProduto05.validacaoDescricao(descricao);
                return descricao;
            }catch (DescricaoProdutoDadosProduto e){
                System.out.println("Erro, campo descrição não pode ser vazio ou conter caracteres.");
                logger.log(Level.WARNING,"Erro de regra de negócio:"+e.getMessage());
            }
        }
    }

    public boolean addProdutoSistema(DadosProduto05 dadosProduto05){
        return produtosCadastrados.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    public boolean retirarProdutoSistema(String nome){
        return produtosCadastrados.remove(nome) == null;
    }

    public boolean alterarDadosProduto(String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        return produtosCadastrados.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        }) !=null;
    }

    public DadosProduto05 buscaPorNome(String nome){
        return produtosCadastrados.get(nome);
    }
    public void listarProdutosSistema(){
        if (produtosCadastrados.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtosCadastrados.forEach((nome, dadosProduto05) -> System.out.println("Nome:"+nome+" |Produto:"+dadosProduto05));
    }

    public void getQuantidadeTotalEstoque(){
        produtosCadastrados.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println("Produto:"+e.getKey()
                +" |Quantidade:"+e.getValue().getQuantidade()));
    }

    public double getValorTotalEstoque(){
        return produtosCadastrados.values().stream()
                .mapToDouble(e -> e.getQuantidade() * e.getPreco()).sum();
    }

    public Map<String, DadosProduto05> getProdutosCadastrados() {
        return produtosCadastrados;
    }
}
