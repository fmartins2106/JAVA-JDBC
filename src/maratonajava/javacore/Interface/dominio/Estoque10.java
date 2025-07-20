package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Estoque10 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Produtobase10> produtobase10s;
    
    public Estoque10(){
        this.produtobase10s = new ArrayList<>();
    }
    
    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Produtobase10.validacaoNome(nome);
                return Produtobase10.formatoString(nome);
            }catch (NomeProdutoBase10 e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                Produtobase10.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase10 e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                Produtobase10.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro, digite um valor válido para quantidade.");
            }catch (QuantidadeProdutoBase10 e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static int validandoEstoqueMinimo(){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                Produtobase10.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro, digite um valor válido para quantidade mínima.");
            }catch (EstoqueMinimoProdutoBase10 e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (dd/mm/aaaa):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel10.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato dd/mm/aaaa");
            }catch (DataValidadePerecivel10 e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static int valindandoMesesGarantia(){
        while (true){
            try {
                System.out.print("Garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis10.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (MesesGarantia10 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis10.validacaoCategoria(categoria);
                return Produtobase10.formatoString(categoria);
            }catch (CategoriaProdutoInvalido10 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(Produtobase10 produtobase10){
        produtobase10s.add(produtobase10);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtobase10s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtobase10s.forEach(System.out::println);
    }

    public void listarProdutosCadastrados(List<Produtobase10> produtobase10s){
        if (produtobase10s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtobase10s.forEach(System.out::println);
    }

    public void listarProdutosVencidos(){
        if (produtobase10s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<Produtobase10> produtosVencidos = new ArrayList<>();
        boolean produtoEncontrado = false;
        for (Produtobase10 produtobase10 : produtobase10s) {
            if (produtobase10 instanceof ProdutoPerecivel10){
                ProdutoPerecivel10 produtoPerecivel10 = (ProdutoPerecivel10) produtobase10;
                if (produtoPerecivel10.estaVencido()){
                    produtosVencidos.add(produtoPerecivel10);
                    produtoEncontrado = true;
                }
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
        }else {
            listarProdutosCadastrados(produtosVencidos);
        }
    }

    public Optional<Produtobase10> pesquisaPorNome(String nome){
        if (produtobase10s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtobase10s.stream().filter(produtobase10 -> produtobase10.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void excluirProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            Iterator<Produtobase10> iterator = produtobase10s.iterator();
            boolean nomeEncontrado = false;
            while (iterator.hasNext()){
                Produtobase10 produtoBase = iterator.next();
                if (produtoBase.getNome().equalsIgnoreCase(nome)){
                    iterator.remove();
                    System.out.println("Dados removidos com sucesso.");
                    nomeEncontrado = true;
                }
            }
            if (!nomeEncontrado){
                System.out.println("Nenhum nome foi encontrado.");
            }
        }else {
            System.out.println("Nenhum produto encontrado.");
        }
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        System.out.println("Pesquisa por faixa de preço de R$"+precoMinimo+" e R$"+precoMaximo);
        boolean precoEncontrado = false;
        List<Produtobase10> produtoEncontrado = new ArrayList<>();
        for (Produtobase10 produtobase10 : produtobase10s) {
            if (produtobase10.getPreco() >= precoMinimo && produtobase10.getPreco() <= precoMaximo){
                produtoEncontrado.add(produtobase10);
                precoEncontrado = true;
            }
        }
        if (!precoEncontrado){
            System.out.println("Nenhum produto cadastrado nessa faixa de preço.");
            return;
        }
        listarProdutosCadastrados(produtoEncontrado);
    }

    public List<Produtobase10> getProdutobase10s() {
        return produtobase10s;
    }
}
