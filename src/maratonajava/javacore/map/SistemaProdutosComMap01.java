package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosLogger05;
import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SistemaProdutosComMap01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = ProdutosLogger05.getLogger(SistemaProdutosComMap01.class);
    private final Map<String, DadosProduto05> produto05Map = new LinkedHashMap<>();

    private static String validandoNome() {
        while (true) {
            try {
                System.out.print("Nome");
                String nome = scanner.nextLine().trim();
                DadosProduto05.validacaoNome(nome);
                return nome;
            } catch (NomeDadosProduto e) {
                System.out.println(e.getMessage());
                logger.log(Level.WARNING, "Erro de regra de negócio:" + e.getMessage());
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
        return produto05Map.putIfAbsent(dadosProduto05.getNome(),dadosProduto05)== null;
    }

    public boolean removerProdutoSistema(String nome){
        return produto05Map.remove(nome) == null;
    }

    public boolean alterarDadosSistema(String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        return produto05Map.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        }) != null;
    }

    public void listarProdutos(){
        if (produto05Map.isEmpty()){
            System.out.println("Produto não encontrado.");
            return;
        }
        produto05Map.forEach( (nome,dadosProduto5) -> System.out.println("Produto:"+nome+" |Dados Produto:"+dadosProduto5));
    }

    public DadosProduto05 buscarProNome(String nome){
        return produto05Map.get(nome);
    }

    public void getQuantidadeTotalEstoque(){
        produto05Map.entrySet().stream().sorted(Comparator.comparing(e-> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println("Produto:"+e.getKey()
                +" |Quantidade"+e.getValue().getQuantidade()));
    }

    public double getValorTotalEstoque(){
        return produto05Map.values().stream()
                .mapToDouble(e -> e.getQuantidade() * e.getPreco()).sum();
    }
}
