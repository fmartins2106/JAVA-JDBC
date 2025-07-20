package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;
import academy.devdojo.maratonajava.javacore.heranca.dominio.ProdutosPereciveis03;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque03 {
    List<ProdutoBase03> produtoBase03s;

    public Estoque03(){
        this.produtoBase03s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase03.validacaoNome(nome);
                return ProdutoBase03.formatoString(nome);
            }catch (NomeProdutoBase03 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase03.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válida.");
            }catch (PrecoProdutoBase03 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQauntidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase03.validacaoQuantidade(quantidade);
                return quantidade;
            } catch (NumberFormatException e) {
                System.out.println("Erro. Digite um número válido.");
            }catch (QuantidadeProdutoBase03 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase03.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válida.");
            }
        }
    }


    public static LocalDate validandoDataValidade(Scanner scanner){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel03.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Digite uma data válida no formato. DD/MM/AAAA.");
            }catch (DataValidadePerecivel03 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int mesesGarantia(Scanner scanner){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis03.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia03 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(Scanner scanner){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis03.validacaoCategoria(categoria);
                return ProdutosNaoPereciveis03.formatoString(categoria);
            }catch (CategoriaProdutoInvalido03 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase03 produtoBase03){
        produtoBase03s.add(produtoBase03);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase03s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase03s.forEach(produtoBase03 -> System.out.println(produtoBase03.getNome() +" |Quantidade:"+produtoBase03.getQuantidade()+" |Preço:R$"+produtoBase03.getPreco()));
    }

    public Optional<ProdutoBase03> pesquisaPorNome(String nome){
        if (produtoBase03s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase03s.stream().filter(produtoBase03 -> produtoBase03.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void removerProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase03s.removeIf(produtoBase03 -> produtoBase03.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido do sistema.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void listarProdutosVencidos(){
        System.out.println("Produtos vencidos.");
        boolean produtoEncontrado = false;
        for (ProdutoBase03 produtoBase03 : produtoBase03s) {
            if (produtoBase03 instanceof ProdutoPerecivel03){
                ProdutoPerecivel03 produtoPerecivel03 = (ProdutoPerecivel03) produtoBase03;
                if (produtoPerecivel03.estaVendido()){
                    System.out.println("Produto:"+produtoPerecivel03.getNome()+" Vencido!");
                    return;
                }
                System.out.println("Não tem nenhum produto vencido.");
            }
        }
    }

    public void atualizarEstoque(String nome, int quantidade){
        Optional<ProdutoBase03> produtoBase03Optional = pesquisaPorNome(nome);
            if (produtoBase03Optional.isPresent()){
                produtoBase03Optional.get().aumentarQuantidade(quantidade);
                System.out.println("Estoque atualizado.");
                return;
            }
            System.out.println("Produto não encontrado.");
    }

    public void filtrarPorFaixaDePreco(double precoMinimo, double precoMaximo){
        boolean encontrou = false;
        System.out.println("Produto na faixa de preco entre R$"+precoMinimo+" e R$"+precoMaximo);
        for (ProdutoBase03 produtoBase03 : produtoBase03s) {
            if (produtoBase03.getPreco() >= precoMinimo && produtoBase03.getPreco() <= precoMaximo){
                System.out.println(produtoBase03.getNome()+" |Preço:R$"+produtoBase03.getPreco()+" |Quantidade:"+produtoBase03.getQuantidade());
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("Nenhum produto nesta faixa de preço.");
        }
    }

    public List<ProdutoBase03> getProdutoBase03s() {
        return produtoBase03s;
    }
}
