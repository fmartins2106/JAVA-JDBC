package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.text.DateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque04 {
    private List<ProdutoBase04> produtoBase04s;

    public Estoque04(){
        this.produtoBase04s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase04.validacaoNome(nome);
                return ProdutoBase04.formatoString(nome);
            }catch (NomeProdutoBase04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase04.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (PrecoProdutoBase04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase04.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para quantidade.");
            }catch (QuantidadeProdutoBase04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase04.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (EstoqueMinimoProdutoBase04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataDeValidade(Scanner scanner){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (dd/mm/aaa):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada, formatter);
                ProdutoPerecivel04.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Digite uma data válida no formato DD/MM/AAAA.");
            }catch (DataValidadePerecivel04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(Scanner scanner){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis04.validacaoGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (MesesGarantia04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String valindandoCategoria(Scanner scanner){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis04.validacaoCategoria(categoria);
                return ProdutosNaoPereciveis04.formatoString(categoria);
            }catch (CategoriaProdutoInvalido04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase04 produtoBase04){
        produtoBase04s.add(produtoBase04);
    }

    public void listarProdutosCadastrados(){
        if (produtoBase04s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase04s.forEach(produtoBase04 -> System.out.println(produtoBase04.getNome() +" |Quantidade:"+produtoBase04.getQuantidade()+" |Preço:R$"+produtoBase04.getPreco()));
    }

    public Optional<ProdutoBase04> pesquisaPorNome(String nome){
        if (produtoBase04s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase04s.stream().filter(produtoBase04 -> produtoBase04.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void removerProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase04s.removeIf(produtoBase04 -> produtoBase04.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void listarProdutosVencidos(){
        System.out.println("Produtos vencidos.");
        boolean produtoEncontrado = false;
        for (ProdutoBase04 produtoBase04 : produtoBase04s) {
            if (produtoBase04 instanceof ProdutoPerecivel04){
                ProdutoPerecivel04 produtoPerecivel04 = (ProdutoPerecivel04) produtoBase04;
                if (produtoPerecivel04.estaVecido()){
                    System.out.println("Produto:"+produtoBase04.getNome()+" está vencido.");
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto vencido.");
        }
    }

    public void atualizarEstoque(String nome, int quantidade){
        Optional<ProdutoBase04> produtoBase04Optional = pesquisaPorNome(nome);
        if (produtoBase04Optional.isPresent()){
            produtoBase04Optional.get().aumentarQuantidade(quantidade);
            System.out.println("Estoque atualizado.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void filtrarPorFaixaPreco(double precoMinimo, double precoMaximo){
        boolean encontrou = false;
        System.out.println("Produto na faixa de preço:R$"+precoMinimo+" e R$"+precoMaximo);
        for (ProdutoBase04 produtoBase04 : produtoBase04s) {
            if (produtoBase04.getPreco() >= precoMinimo && produtoBase04.getPreco() <= precoMaximo){
                System.out.println("Produto:"+produtoBase04.getNome()+" |Quantidade:"+produtoBase04.getQuantidade()+" |R$"+produtoBase04.getPreco());
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("Nenum produto nesta faixa de preço;");
        }
    }

    public List<ProdutoBase04> getProdutoBase04s() {
        return produtoBase04s;
    }
}
