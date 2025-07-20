package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque08 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<ProdutoBase08> produtoBase08s;

    public Estoque08(){
        this.produtoBase08s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase08.validacaoNome(nome);
                return ProdutoBase08.formatoString(nome);
            }catch (NomeProdutoBase08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase08.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (PrecoProdutoBase08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase08.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (QuantidadeProdutoBase08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int estoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase08.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (EstoqueMinimoProdutoBase08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade:");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel08.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataValidadePerecivel08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int mesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis08.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (MesesGarantia08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis08.validacaoCategoria(categoria);
                return ProdutoBase08.formatoString(categoria);
            }catch (CategoriaProdutoInvalido08 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase08 produtoBase08){
        produtoBase08s.add(produtoBase08);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase08s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrados.");
            return;
        }
        for (ProdutoBase08 produtoBase08 : produtoBase08s) {
            System.out.println("Produto:"+produtoBase08.getNome()+" |Preço:R$"+produtoBase08.getPreco()+" |Quantidade:"+produtoBase08.getQuantidade()+" |Estoque mínimo:"+produtoBase08.getEstoqueMinimo());
            if (produtoBase08 instanceof ProdutoPerecivel08){
                ProdutoPerecivel08 produtoPerecivel08 = (ProdutoPerecivel08) produtoBase08;
                System.out.println(" |Data validade:"+produtoPerecivel08.getDataValidade()+" |Está vencido?:"+(produtoPerecivel08.estaVencido() ? "Sim." : "Não."));
            }
            if (produtoBase08 instanceof ProdutosNaoPereciveis08){
                ProdutosNaoPereciveis08 produtosNaoPereciveis08 = (ProdutosNaoPereciveis08) produtoBase08;
                System.out.println(" |Meses de garantia:"+produtosNaoPereciveis08.getMesesGarantia()+" |Categoria:"+produtosNaoPereciveis08.getCategoria());
            }
        }
    }

    public Optional<ProdutoBase08> pesquisaPorNome(String nome){
        if (produtoBase08s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase08s.stream().filter(produtoBase08 -> produtoBase08.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void removerProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase08s.removeIf(produtoBase08 -> produtoBase08.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrad.");
    }

    public void listarProdutosVencidos(){
        if (produtoBase08s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        boolean produtoVencido = false;
        for (ProdutoBase08 produtoBase08 : produtoBase08s) {
            if (produtoBase08 instanceof ProdutoPerecivel08){
                ProdutoPerecivel08 produtoPerecivel08 = (ProdutoPerecivel08) produtoBase08;
                if (produtoPerecivel08.estaVencido()){
                    System.out.println("Produto:"+produtoBase08.getNome()+" está vencido.");
                    produtoVencido = true;
                }
            }
        }
        if (!produtoVencido){
            System.out.println("Nenhum produto vencido.");
        }
    }

    public void filtrarProFaixaDePreco(double precoMinimo, double precoMaximo){
        System.out.println("Pesquisa por faixa de preço -> preco mínimo:R$"+precoMinimo+" e preço máximo:R$"+precoMaximo);
        boolean produtoEncontrado = false;
        for (ProdutoBase08 produtoBase08 : produtoBase08s) {
            if (produtoBase08.getPreco() >= precoMinimo && produtoBase08.getPreco() <= precoMaximo){
                System.out.println("Nome:"+produtoBase08.getNome()+" |Preço:R$"+produtoBase08.getPreco()+
                        " |Quantidade:"+produtoBase08.getQuantidade()+" |Estoque mínimo:"+produtoBase08.getEstoqueMinimo());
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
        }
    }

    public List<ProdutoBase08> getProdutoBase08s() {
        return produtoBase08s;
    }
}
