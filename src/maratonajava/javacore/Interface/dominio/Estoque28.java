package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException28;
import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque28 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase28> produtoBase28s;

    public Estoque28(){
        this.produtoBase28s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase28.validacaoNomeProduto(nome);
                return ProdutoBase28.formatoString(nome);
            }catch (NomeProdutoBase28 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase28.validacaoValorProduto(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (ValorFaturaException28 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase28.validacaoQuantidadeProduto(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Nome inválido.");
            }catch (QuantidadeProdutoBase28 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase28.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (EstoqueMinimoProdutoBase28 e){
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
                ProdutoPerecivel28.validacaoValidade(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int garantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis28.validacaoMesesGarantia(garantia);
                return garantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (MesesGarantia28 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis28.validacaoCategoria(categoria);
                return ProdutoBase28.formatoString(categoria);
            }catch (CategoriaProdutoInvalido28 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoEstoque(ProdutoBase28 produtoBase28){
        produtoBase28s.add(produtoBase28);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutosSistema(){
        if (produtoBase28s.isEmpty()){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        produtoBase28s.forEach(System.out::println);
    }

    public void listarProdutosSistema(List<ProdutoBase28> produtoBase28s){
        if (produtoBase28s.isEmpty()){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        produtoBase28s.forEach(System.out::println);
    }

    public void listarProdutosVencidos(){
        if (produtoBase28s.isEmpty()){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        List<ProdutoBase28> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase28 produtoBase28 : produtoBase28s) {
            if (produtoBase28 instanceof ProdutoPerecivel28){
                ProdutoPerecivel28 produtoPerecivel28 = (ProdutoPerecivel28) produtoBase28;
                if (produtoPerecivel28.estaVencido()){
                    produtosVencidos.add(produtoPerecivel28);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosSistema(produtosVencidos);
    }

    public Optional<ProdutoBase28> pesquisaPorNome(String nome){
        if (produtoBase28s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return Optional.empty();
        }
        return produtoBase28s.stream().filter(produtoBase28 -> produtoBase28.nome.equalsIgnoreCase(nome)).findFirst();
    }

    public void exibirPesquisaPorNome(String nome){
        pesquisaPorNome(nome).ifPresentOrElse(produtoBase28 -> System.out.println("Produto encontrado:"+produtoBase28),
        () -> System.out.println("Nenhum produto foi encontrado."));
    }

    public void excluirProdutoSistema(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase28s.removeIf(produtoBase28 -> produtoBase28.nome.equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        List<ProdutoBase28> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase28 produtoBase28 : produtoBase28s) {
            if (produtoBase28.getValor() >= precoMinimo && produtoBase28.getValor() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase28);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        listarProdutosSistema(produtosNaFaixaDePreco);
    }

    public List<ProdutoBase28> getProdutoBase28s() {
        return produtoBase28s;
    }
}
