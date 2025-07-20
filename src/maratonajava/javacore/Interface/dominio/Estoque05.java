package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque05 {
    private List<ProdutoBase05> produtoBase05s;

    public Estoque05(){
        this.produtoBase05s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase05.validacaoNome(nome);
                return ProdutoBase05.formatoString(nome);
            }catch (NomeProdutoBase05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase05.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase05.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Quantidade inválida.");
            }catch (QuantidadeProdutoBase05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase05.validacaoEstoqueMimimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(Scanner scanner){
        while (true){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                System.out.print("Digite a data de validade no formato (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel05.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Data inválida. Tente novamente.");
            }catch (DataValidadePerecivel05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(Scanner scanner){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis05.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }catch (MesesGarantia05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(Scanner scanner){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis05.validacaoCategoria(categoria);
                return ProdutoBase05.formatoString(categoria);
            }catch (CategoriaProdutoInvalido05 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase05 produtoBase05){
        produtoBase05s.add(produtoBase05);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutos(){
        if (produtoBase05s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase05s.forEach(produtoBase05 -> System.out.println("Nome:"+produtoBase05.getNome()+" |Quantidade:"+produtoBase05.getQuantidade()+" |Preço:R$"+produtoBase05.getPreco()+" |Estoque mínimo:"+produtoBase05.getEstoqueMinimo()));
    }

    public Optional<ProdutoBase05> pesquisaPorNome(String nome){
        if (produtoBase05s.isEmpty()){
            System.out.println("Nenhum nome foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase05s.stream().filter(produtoBase05 -> produtoBase05.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void removerProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase05s.removeIf(produtoBase05 -> produtoBase05.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }


    public void listarProdutosVencidos(){
        System.out.println("Produtos vencidos.");
        boolean produtoEncontrado = false;
        for (ProdutoBase05 produtoBase05 : produtoBase05s) {
            if (produtoBase05 instanceof ProdutoPerecivel05){
                ProdutoPerecivel05 produtoPerecivel05 = (ProdutoPerecivel05) produtoBase05;
                if (produtoPerecivel05.estaVencido()){
                    System.out.println("Produto:"+produtoPerecivel05.getNome()+" está vencido.");
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Produto não encotrado.");
        }
    }

    public void atualiarEstoque(String nome, int quantidade){
        Optional<ProdutoBase05> produtoBase05Optional = pesquisaPorNome(nome);
        if (produtoBase05Optional.isPresent()){
            produtoBase05Optional.get().aumentarQuantidade();
            System.out.println("Estoque atualizado.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void filtrarPorFaixaDePreco(double precoMinimo, double precoMaximo){
        if (produtoBase05s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        boolean produtoEncontrado = false;
        for (ProdutoBase05 produtoBase05 : produtoBase05s) {
            if (produtoBase05.getPreco() >= precoMinimo && produtoBase05.getPreco() <= precoMaximo){
                System.out.println("Produto:"+produtoBase05.getNome()+" |Quantidade:"+produtoBase05.getQuantidade()+" |Estoque mínimo:"+produtoBase05.getEstoqueMinimo()+" |Preço:R$"+ produtoBase05.getPreco());
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado nesta faixa de preço.");
        }
    }

    public List<ProdutoBase05> getProdutoBase05s() {
        return produtoBase05s;
    }
}
