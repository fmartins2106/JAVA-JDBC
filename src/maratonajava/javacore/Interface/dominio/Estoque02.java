package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Estoque02 {
    private List<ProdutoBase02> produtoBase02s;

    public Estoque02(){
        this.produtoBase02s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase02.validacaoNome(nome);
                return ProdutoBase02.formatoString(nome);
            }catch (NomeProdutoBase02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase02.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (PrecoProdutoBase02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase02.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (QuantidadeProdutoBase02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase02.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para estoque mínimo.");
            }catch (EstoqueMinimoProdutoBase02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoData(Scanner scanner){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel02.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Digite uma data válida. Use o formato DD/MM/AAAA");
            }catch (DataValidadePerecivel02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoGarantia(Scanner scanner){
        while (true){
            try {
                System.out.print("Garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis02.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para garantia.");
            }catch (MesesGarantia02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(Scanner scanner){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis02.validacaoCategoria(categoria);
                return ProdutosNaoPereciveis02.formatoString(categoria);
            }catch (CategoriaProdutoInvalido02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase02 produtoBase02){
        produtoBase02s.add(produtoBase02);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutosCadastrados(){
        if (produtoBase02s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase02s.forEach(produtoBase02 -> System.out.println(produtoBase02.getNome() +" |Quantidade:"+produtoBase02.quantidade+" |Preço:R$"+produtoBase02.getPreco()));
    }


    public Optional<ProdutoBase02> pesquisaPorNome(String nome){
        if (produtoBase02s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase02s.stream().filter(produtoBase02 -> produtoBase02.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void removerProduto(String nome){
        if (pesquisaPorNome(nome).isPresent()){
            produtoBase02s.removeIf(produtoBase02 -> produtoBase02.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
        }else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void listarProdutosVencidos(){
        System.out.println("Produtos vencidos.");
        boolean encontrado = false;
        for (ProdutoBase02 produtoBase02 : produtoBase02s) {
            if (produtoBase02 instanceof ProdutoPerecivel02){
                ProdutoPerecivel02 produtosPereciveis02 = (ProdutoPerecivel02) produtoBase02;
                if (produtosPereciveis02.estaVencido()){
                    System.out.println("Produto:"+produtosPereciveis02.getNome()+" Vencido!");
                    return;
                }
                System.out.println("Não tem nenhum produto vencido.");
            }
        }
    }

    public void atualizarEstoque(String nome, int quantidade){
        Optional<ProdutoBase02> produtoBase02Optional = pesquisaPorNome(nome);
        if (produtoBase02Optional.isPresent()){
            produtoBase02Optional.get().aumentarQuantidade(quantidade);
            System.out.println("Estoque atualizado.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void filtrarProFaixaDePreco(double precoMinimo, double precoMaximo){
        boolean encontrou = false;
        System.out.println("Produtos na faixa de preço de R$"+precoMinimo+" e R$"+precoMaximo+":");
        for (ProdutoBase02 produtoBase02 : produtoBase02s) {
            if (produtoBase02.getPreco() >= precoMinimo && produtoBase02.getPreco() <= precoMaximo){
                System.out.println("Produto:"+produtoBase02.getNome()+" |Preço:R$"+produtoBase02.getPreco()+" |Quantidade:"+produtoBase02.getQuantidade());
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("Nenhum produto foi encontrado nesta faixa de preço.");
        }
    }

    public List<ProdutoBase02> getProdutoBase02s() {
        return produtoBase02s;
    }
}
