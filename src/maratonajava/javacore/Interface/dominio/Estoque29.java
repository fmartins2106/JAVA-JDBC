package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque29 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase29> produtoBase29s;

    public Estoque29(){
        this.produtoBase29s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase29.validacaoNome(nome);
                return ProdutoBase29.formatoNome(nome);
            }catch (NomeProdutoBase29 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase29.validacaoPrecoProduto(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase29 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase29.validacaoQuantidadeProduto(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Quantidade inválida.");
            }catch (QuantidadeProdutoBase29 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase29.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Estoque mínimo inválido.");
            }catch (EstoqueMinimoProdutoBase29 e){
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
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel29.validacaoDataValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato DD/MM/AAAA");
            }catch (DataValidadePerecivel29 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutoNaoPerecivel29.validacaoGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir garantia.");
            }catch (MesesGarantia29 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutoNaoPerecivel29.validacaoCategoria(categoria);
                return categoria;
            }catch (CategoriaProdutoInvalido29 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase29 produtoBase29){
        produtoBase29s.add(produtoBase29);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutoCadastrados(){
        if (produtoBase29s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase29s.forEach(System.out::println);
    }


    public void listarProdutoCadastrados(List<ProdutoBase29> produtoBase29s){
        if (produtoBase29s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase29s.forEach(System.out::println);
    }

    public void listarProdutoVencidos(){
        if (produtoBase29s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        List<ProdutoBase29> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase29 produtoBase29 : produtoBase29s) {
            if (produtoBase29 instanceof ProdutoPerecivel29){
                ProdutoPerecivel29 produtoPerecivel29 = (ProdutoPerecivel29) produtoBase29;
                if (produtoPerecivel29.estaVencido()){
                    produtosVencidos.add(produtoPerecivel29);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutoCadastrados(produtosVencidos);
    }

    public Optional<ProdutoBase29> pesquisaPorNome(String nome){
        if (produtoBase29s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase29s.stream().filter(produtoBase29 -> produtoBase29.nome.equalsIgnoreCase(nome)).findFirst();
    }

    public void exibirPesquisaPorNome(String nome){
        pesquisaPorNome(nome).ifPresentOrElse(produtoBase29 -> System.out.println("Produto encontrado"+produtoBase29),
        ()-> System.out.println("Nenhum produto foi encontrado."));
    }

    public void excluirProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase29s.removeIf(produtoBase29 -> produtoBase29.getNome().equalsIgnoreCase(nome));
            return;
        }
        System.out.println("Nenhum produto encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase29> listaProdutosNaFaixaPreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase29 produtoBase29 : produtoBase29s) {
            if (produtoBase29.getPreco() >= precoMinimo && produtoBase29.getPreco() <= precoMaximo){
                listaProdutosNaFaixaPreco.add(produtoBase29);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        listarProdutoCadastrados(listaProdutosNaFaixaPreco);
    }

    public List<ProdutoBase29> getProdutoBase29s() {
        return produtoBase29s;
    }
}
