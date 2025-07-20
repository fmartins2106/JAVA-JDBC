package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.NomeEventoBase12;
import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque12 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase12> produtoBase12s;

    public Estoque12() {
        this.produtoBase12s = new ArrayList<>();
    }

    public static String validandoNome() {
        while (true) {
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase12.validacaoNome(nome);
                return ProdutoBase12.formatoString(nome);
            } catch (NomeEventoBase12 e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco() {
        while (true) {
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase12.validacaoPreco(preco);
                return preco;
            } catch (NumberFormatException e) {
                System.out.println("Erro. Digite um valor válido para preço.");
            } catch (PrecoProdutoBase12 e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade() {
        while (true) {
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase12.validacaoQuantidade(quantidade);
                return quantidade;
            } catch (NumberFormatException e) {
                System.out.println("Erro. Quantidade inválida.");
            } catch (QuantidadeProdutoBase12 e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo() {
        while (true) {
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase12.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            } catch (NumberFormatException e) {
                System.out.println("Erro. valor inválido.");
            } catch (EstoqueMinimoProdutoBase12 e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Data validade:");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada, formatter);
                ProdutoPerecivel12.validacaoDataValidade(dataValidade);
                return dataValidade;
            } catch (DateTimeException e) {
                System.out.println("Data inválida.");
            } catch (DataValidadePerecivel12 e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia() {
        while (true) {
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis12.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            } catch (NumberFormatException e) {
                System.out.println("Erro. Digite um valor válido.");
            } catch (MesesGarantia12 e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria() {
        while (true) {
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis12.validacaoCategoria(categoria);
                return categoria;
            } catch (CategoriaProdutoInvalido12 e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase12 produtoBase12) {
        produtoBase12s.add(produtoBase12);
        System.out.println("Produto criado com sucesso.");
    }

    public void listarProdutosCadastrados() {
        if (produtoBase12s.isEmpty()) {
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase12s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<ProdutoBase12> produtoBase12s) {
        if (produtoBase12s.isEmpty()) {
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase12s.forEach(System.out::println);
    }

    public Optional<ProdutoBase12> pesquisaPorNome(String nome){
        if (produtoBase12s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase12s.stream().filter(produtoBase12 -> produtoBase12.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirDados(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase12s.removeIf(produtoBase12 -> produtoBase12.getNome().equalsIgnoreCase(nome));
            return;
        }
        System.out.println("Nome não encontrado. Tente novamente.");
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        System.out.println("Pesquisa por faixa de preço R$"+precoMinimo+" e R$"+precoMaximo);
        List<ProdutoBase12> produtosNaFaixaDePreco = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase12 produtoBase12 : produtoBase12s) {
            if (produtoBase12.getPreco() >= precoMinimo && produtoBase12.getPreco() <= precoMaximo){
                produtosNaFaixaDePreco.add(produtoBase12);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Produto não encontrado.");
        }else {
            listarProdutosCadastrados(produtosNaFaixaDePreco);
        }
    }

    public void listarProdutosVencidos(){
        if (produtoBase12s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<ProdutoBase12> ListaProdutosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (ProdutoBase12 produtoBase12 : produtoBase12s) {
            if (produtoBase12 instanceof ProdutoPerecivel12){
                ProdutoPerecivel12 produtoPerecivel12 = (ProdutoPerecivel12) produtoBase12;
                if (produtoPerecivel12.estaVencido()){
                    ListaProdutosVencidos.add(produtoPerecivel12);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
        }else {
            listarProdutosCadastrados(ListaProdutosVencidos);
        }
    }



}