package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Estoque06 {
    private List<ProdutoBase06> produtoBase06s;

    public Estoque06(){
        this.produtoBase06s = new ArrayList<>();
    }

    public static String validacaoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                ProdutoBase06.validacaoNome(nome);
                return ProdutoBase06.formatoString(nome);
            }catch (NomeProdutoBase06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                ProdutoBase06.validacaoPreco(valor);
                return valor;
            }catch (PrecoProdutoBase06 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido. Tente novamente.");
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase06.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (QuantidadeProdutoBase06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine().trim());
                ProdutoBase06.validacaoEstoqueMinimo(estoqueMinimo);
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido. Tente novamente.");
            }catch (EstoqueMinimoProdutoBase06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(Scanner scanner){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade(DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(entrada,formatter);
                ProdutoPerecivel06.validacaoDataValidade(dataValidade);
                return dataValidade;
            }catch (DateTimeException e){
                System.out.println("Digite uma data válida no formato DD/MM/AAAA.");
            }catch (DataValidadePerecivel06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMesGarantia(Scanner scanner){
        while (true){
            try {
                System.out.print("Meses de garantia:");
                int mesesGarantia = Integer.parseInt(scanner.nextLine().trim());
                ProdutosNaoPereciveis06.validacaoMesesGarantia(mesesGarantia);
                return mesesGarantia;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (MesesGarantia06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCategoria(Scanner scanner){
        while (true){
            try {
                System.out.print("Categoria:");
                String categoria = scanner.nextLine().trim();
                ProdutosNaoPereciveis06.validacaoCategoria(categoria);
                return ProdutoBase06.formatoString(categoria);
            }catch (CategoriaProdutoInvalido06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutoSistema(ProdutoBase06 produtoBase06){
        produtoBase06s.add(produtoBase06);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void listarProdutoCadastrados(){
        if (produtoBase06s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtoBase06s.forEach(produtoBase06 -> System.out.println("Nome:"+produtoBase06.getNome()+"|Preço:R$"+produtoBase06.getPreco()+" |Quantidade:"+produtoBase06.getQuantidade()+" |Estoque mínimo:"+produtoBase06.getEstoqueMinimo()));
    }

    public Optional<ProdutoBase06> pesquisaPorNomeProduto(String nome){
        if (produtoBase06s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return Optional.empty();
        }
        return produtoBase06s.stream().filter(produtoBase06 -> produtoBase06.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public void removerProduto(String nome){
        if (pesquisaPorNomeProduto(nome).isPresent()){
            produtoBase06s.removeIf(produtoBase06 -> produtoBase06.getNome().equalsIgnoreCase(nome));
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    public void listarProdutoVencidos(){
        if (produtoBase06s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        boolean produtoVencido = false;
        for (ProdutoBase06 produtoBase06 : produtoBase06s) {
            if (produtoBase06 instanceof ProdutoPerecivel06){
                ProdutoPerecivel06 produtoPerecivel06 = (ProdutoPerecivel06) produtoBase06;
                if (produtoPerecivel06.estaVencido()){
                    System.out.println("Produto:"+produtoBase06.getNome()+" está vencido.");
                    produtoVencido = true;
                }
            }
        }
        if (!produtoVencido){
            System.out.println("Nenhum produto foi encontrado.");
        }
    }

    public void pesquisaPorFaixaDePreco(double precoMinimo, double precoMaximo){
        boolean produtoEncontrado = false;
        System.out.println("Produto na faixa de preço de R$"+precoMinimo+" e R$"+precoMaximo);
        for (ProdutoBase06 produtoBase06 : produtoBase06s) {
            if (produtoBase06.getPreco() >= precoMinimo && produtoBase06.getPreco() <= precoMaximo){
                System.out.println("Produto:"+produtoBase06.getNome()+" |Preço:R$"+produtoBase06.getPreco()+" |Quantidade:"+produtoBase06.getQuantidade()+" |Estoque mínimo:"+produtoBase06.getEstoqueMinimo());
                produtoEncontrado = true;
            }
        }
        if (!produtoEncontrado){
            System.out.println("Nenhum produto esta faixa de preço;");
        }
    }


    public List<ProdutoBase06> getProdutoBase06s() {
        return produtoBase06s;
    }
}
