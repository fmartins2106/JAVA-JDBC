package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque15 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase15> produtoBase15s;

    public Estoque15(){
        this.produtoBase15s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase15.validacaoNome(nome);
                return ProdutoBase15.formatoString(nome);
            }catch (NomeProdutoBase15 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase15.validacaoPreco(preco);
                return preco;
            }catch (PrecoProdutoBase15 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase15.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma quantidade válida.");
            }catch (QuantidadeProdutoBase15 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínima:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase15.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase15 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel15.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis15.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia15 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis15.validacaoCategoria(categoria);
                return ProdutoBase15.formatoString(categoria);
            }catch (CategortiaProdutoInvalido15 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addOProdutoSistema(ProdutoBase15 produtoBase15){
        produtoBase15s.add(produtoBase15);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase15s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase15s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase15> produtoBase15s){
        if (produtoBase15s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        produtoBase15s.forEach(System.out::println);
    }

    public Optional<ProdutoBase15> pesquisaPorNome(String nome){
        if (produtoBase15s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return Optional.empty();
        }
        return produtoBase15s.stream().filter(produtoBase15 -> produtoBase15.nome.equalsIgnoreCase(nome)).findFirst();
    }

    public void listarProdutosVencidos(){
        if (produtoBase15s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase15> produtosVencidos = new ArrayList<>();
        boolean produtoVencido = false;
        for (ProdutoBase15 produtoBase15 : produtoBase15s) {
            if (produtoBase15 instanceof ProdutoPerecivel15){
                ProdutoPerecivel15 produtoPerecivel15 = (ProdutoPerecivel15) produtoBase15;
                if (produtoPerecivel15.estaVencido()){
                    produtosVencidos.add(produtoPerecivel15);
                    produtoVencido = true;
                }
            }
        }
        if (!produtoVencido){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosVencidos);
    }


    public void excluirDadosProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase15s.removeIf(produtoBase15 -> produtoBase15.nome.equalsIgnoreCase(nome));
            return;
        }
        System.out.println("Nenhum produto encontrado.");
    }


    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase15> produtosEncontrado = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase15 produtoBase15 : produtoBase15s) {
            if (produtoBase15.getPreco() >= precoMinimo && produtoBase15.getPreco() <= precoMaximo){
                produtosEncontrado.add(produtoBase15);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(produtosEncontrado);
    }


    public List<ProdutoBase15> getProdutoBase15s() {
        return produtoBase15s;
    }
}
