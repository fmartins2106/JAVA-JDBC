package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque01 {
    private List<ProdutoBase01> produtoBase01s;

    public Estoque01(){
        this.produtoBase01s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase01.validacaoNome(nome);
                return ProdutoBase01.formatoNome(nome);
            }catch (NomeProdutoBase01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase01.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (PrecoProdutoBase01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase01.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (QuantidadeProdutoBase01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase01.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(Scanner scanner){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis01.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }catch (MesesGarantia01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(Scanner scanner){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis01.validacaoCategoria(categoria);
                return ProdutoBase01.formatoNome(categoria);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (CategoriaProdutoInvalida01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase01 produtoBase01){
        produtoBase01s.add(produtoBase01);
    }

    public Optional<ProdutoBase01> buscarProdutoPorNome(String nome){
        if (produtoBase01s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado");
            return Optional.empty();
        }
        return produtoBase01s.stream().filter(produtoBase01 -> produtoBase01.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void listarProdutos(){
        if (produtoBase01s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase01s.forEach(produtoBase01 -> System.out.println(produtoBase01.getNome() +" |Quantidade:"+produtoBase01.getQuantidade()));
    }

    public void listarProdutosVencidos(){
        System.out.println("Produtos vencidos:");
        boolean encontrado = false;
        for (ProdutoBase01 produtoBase01 : produtoBase01s) {
            ProdutoPerecivel01 produtoPerecivel01 = (ProdutoPerecivel01) produtoBase01;
            if (produtoPerecivel01.estaVencido()){
                System.out.println("Produto:"+produtoPerecivel01.getNome()+" Vencido!");
            }
        }
    }

    public void removerProduto(String nome){
        if (buscarProdutoPorNome(nome).isPresent()){
            produtoBase01s.removeIf(produtoBase01 -> produtoBase01.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
        }else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void atualizarEstoque(String nome, int quantidade){
        Optional<ProdutoBase01> produtoBase01Optional = buscarProdutoPorNome(nome);
        if (produtoBase01Optional.isPresent()){
            produtoBase01Optional.get().aumentarQuantidade(quantidade);
            System.out.println("Estoque atualizado.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void filtrarProdutoPorFaixaPreco(double precoMinimo, double precoMaximo){
        boolean encontrou = false;
        System.out.println("Produtos na faixa de preco:"+precoMinimo+ " e "+precoMaximo+":");
        for (ProdutoBase01 produtoBase01 : produtoBase01s) {
            if (produtoBase01.getPreco() >= precoMinimo && produtoBase01.getPreco() <= precoMaximo){
                System.out.println("Produto:"+produtoBase01.getNome()+" |Preço:R$"+produtoBase01.getPreco()+" |Quantidade:"+produtoBase01.getQuantidade());
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("Nenhum produto foi encontrado nesta faixa de preço.");
        }
    }

    public List<ProdutoBase01> getProdutoBase01s() {
        return produtoBase01s;
    }
}
