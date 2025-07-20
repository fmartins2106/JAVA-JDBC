package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque09 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<ProdutoBase09> produtoBase09s;

    public Estoque09(){
        this.produtoBase09s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase09.validacaoNome(nome);
                return ProdutoBase09.formatoString(nome);
            }catch (NomeProdutoBase09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase09.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase09.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para quantidade.");
            }catch (QuantidadeProdutoBase09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase09.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para estoque mínimo.");
            }
        }
    }


    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data validade:");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel09.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Data inválida. Tente novamente.");
            }catch (DataValidadePerecivel09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Meses garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis09.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir garanti.");
            }catch (MesesGarantia09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis09.validacaoCategoria(categoria);
                return ProdutoBase09.formatoString(categoria);
            }catch (CategoriaProdutoInvalido09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase09 produtoBase09){
        produtoBase09s.add(produtoBase09);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        listarProdutosCadastrados(produtoBase09s);
    }

    public void listarProdutosCadastrados(List<ProdutoBase09> produtoBase09s){
        if (produtoBase09s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        for (ProdutoBase09 produtoBase09 : produtoBase09s) {
            if (produtoBase09 instanceof ProdutoPerecivel09){
                ProdutoPerecivel09 produtoPerecivel09 = (ProdutoPerecivel09) produtoBase09;
                System.out.println("Nome:"+produtoPerecivel09.getNome()+" |Preço:R$"+produtoPerecivel09.getPreco()+" |Quantidade:"+produtoPerecivel09.getQuantidade()+" |Estoque mínimo:"+produtoPerecivel09.getEstoqueMinimo());
                System.out.println("|Data validade:"+produtoPerecivel09.getDataValidade());
            }
            if (produtoBase09 instanceof ProdutosNaoPereciveis09){
                ProdutosNaoPereciveis09 produtosNaoPereciveis09 = (ProdutosNaoPereciveis09) produtoBase09;
                System.out.println("Nome:"+produtosNaoPereciveis09.getNome()+" |Preço:R$"+produtosNaoPereciveis09.getPreco()+" |Quantidade:"+produtosNaoPereciveis09.getQuantidade()+" |Estoque mínimo:"+produtosNaoPereciveis09.getEstoqueMinimo());
                System.out.println("Meses garantia:"+produtosNaoPereciveis09.getMesesGarantia()+" |Categoria:"+((ProdutosNaoPereciveis09) produtoBase09).getCategoria());
            }
        }
    }

    public void listarProdutosVencido(){
        if (produtoBase09s.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        boolean produtoVencido = false;
        for (ProdutoBase09 produtoBase09 : produtoBase09s) {
            if (produtoBase09 instanceof ProdutoPerecivel09){
                ProdutoPerecivel09 produtoPerecivel09 = (ProdutoPerecivel09) produtoBase09;
                if (produtoPerecivel09.estaVencido()){
                    System.out.println("Produto:"+produtoPerecivel09.getNome()+" Está vencido.");
                    produtoVencido = true;
                }
            }
        }
        if (!produtoVencido){
            System.out.println("Nenhum produto vencido foi encontrado.");
        }
    }

    public Optional<ProdutoBase09> pesquisaPorNome(String nome){
        if (produtoBase09s.isEmpty()){
            System.out.println("Nenhum produto foi registrado.");
            return Optional.empty();
        }
        return produtoBase09s.stream().filter(produtoBase10 -> produtoBase10.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void removerProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            System.out.println("Nome não encontrado.");
            return;
        }
        produtoBase09s.removeIf(produtoBase09 -> produtoBase09.getNome().equalsIgnoreCase(nome));
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        System.out.println("Pesquisa de por faixa de preço: de R$"+precoMinimo+" a R$"+precoMaximo);
        boolean produtoEncontrado = false;
        List<ProdutoBase09> filtrados = new ArrayList<>();
        for (ProdutoBase09 produtoBase09 : produtoBase09s) {
            if (produtoBase09.getPreco() >= precoMinimo && produtoBase09.getPreco() <= precoMaximo){
                filtrados.add(produtoBase09);
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhm produto foi encontrado.");
            return;
        }
        listarProdutosCadastrados(filtrados);
    }

    public List<ProdutoBase09> getProdutoBase09s() {
        return produtoBase09s;
    }
}
