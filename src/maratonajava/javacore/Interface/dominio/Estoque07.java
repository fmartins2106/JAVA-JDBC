package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque07 {
    private List<ProdutoBase07> produtoBase07s;

    public Estoque07(){
        this.produtoBase07s = new ArrayList<>();
    }

    public static String validacaoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase07.validacaoNome(nome);
                return ProdutoBase07.formatoString(nome);
            }catch (NomeProdutoBase07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase07.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase07.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma quantidade válida.");
            }catch (QuantidadeProdutoBase07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase07.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }catch (EstoqueMinimoProdutoBase07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(Scanner scanner){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Digite data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel07.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro, digite uma data no formato dd/mm/yyyy.");
            }catch (DataValidadePerecivel07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(Scanner scanner){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPerecivel07.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(Scanner scanner){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPerecivel07.validacaoCategoria(categoria);
                return ProdutoBase07.formatoString(categoria);
            }catch (CategoriaProdutoInvalido07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase07 produtoBase07){
        produtoBase07s.add(produtoBase07);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutoCadastrados(){
        if (produtoBase07s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (ProdutoBase07 produtoBase07 : produtoBase07s) {
            System.out.println("Produto:Nome:"+produtoBase07.getNome()+"|Preço:"+produtoBase07.getPreco()+" |Estoque:"+produtoBase07.getQuantidade()+" |Estoque mínimo:"+produtoBase07.getEstoqueMinimo());
            if (produtoBase07 instanceof ProdutoPerecivel07){
                ProdutoPerecivel07 produtoPerecivel07 = (ProdutoPerecivel07) produtoBase07;
                System.out.println(" |Data validade:"+produtoPerecivel07.getDataValidade() +
                        (produtoPerecivel07.estaVencido() ? "VENCIDO" : ""));
            }
            if (produtoBase07 instanceof ProdutosNaoPerecivel07){
                ProdutosNaoPerecivel07 produtosNaoPerecivel07 = (ProdutosNaoPerecivel07) produtoBase07;
                System.out.println(" |Meses garantia:"+ produtosNaoPerecivel07.getMesesGarantia()+ " |Categoria: "+ produtosNaoPerecivel07.getCategoria());
            }
        }
    }

    public Optional<ProdutoBase07> pesquisaPorNome(String nome){
        if (produtoBase07s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase07s.stream().filter(produtoBase07 -> produtoBase07.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void removerProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase07s.removeIf(produtoBase07 -> produtoBase07.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void listarProdutosVencidos(){
        if (produtoBase07s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        boolean produtoEncontrado = false;
        for (ProdutoBase07 produtoBase07 : produtoBase07s) {
            if (produtoBase07 instanceof ProdutoPerecivel07){
                ProdutoPerecivel07 produtoPerecivel07 = (ProdutoPerecivel07) produtoBase07;
                if (produtoPerecivel07.estaVencido()){
                    System.out.println("Produto:"+produtoPerecivel07.getNome()+" está vencido.");
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto vencido.");
        }
    }

    public void filtrarProdutoPorFaixaDePreco(double precoMinimo, double precoMaximo){
        System.out.println("Pesquisa de produto, faixa de preço:R$"+precoMinimo+" e R$"+precoMaximo);
        boolean produtoEncontrado = false;
        for (ProdutoBase07 produtoBase07 : produtoBase07s) {
            if (produtoBase07.getPreco() >= precoMinimo && produtoBase07.getPreco() <= precoMaximo){
                System.out.println("Produto:"+produtoBase07.getNome()+" |Preço:R$"+produtoBase07.getPreco()+" |Quantidade:"+produtoBase07.getQuantidade()+" |Estoque mínimo:"+produtoBase07.getEstoqueMinimo());
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto nesta faixa de preço.");
        }
    }

    public List<ProdutoBase07> getProdutoBase07s() {
        return produtoBase07s;
    }
}
