package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque10 {
    List<Produto10> produto10s;

    public Estoque10(){
        this.produto10s = new ArrayList<>();
    }

    public void addProdutos(Produto10 produto10){
        produto10s.add(produto10);
    }

    public boolean validandoString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}\\p{N}]+( [\\p{L}\\p{N}]+)+$")){
            System.out.println("Campo não pode ser vazio ou conter caracteres, digite descrição completa.");
            return false;
        }
        return true;
    }


    public static int validandoCodigo(Scanner scanner,List<Produto10> produto10s){
        while (true){
            try {
                System.out.print("Código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                if (codigo < Produto10.CODIGO_MINIMO){
                    System.out.println("Código não pode ser menor que "+Produto10.CODIGO_MINIMO);
                    continue;
                }
                if (produto10s.stream().anyMatch( p -> p.getCodigo() == codigo)){
                    System.out.println("Código existente. Tente outro.");
                    continue;
                }
                return codigo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoNomes(Scanner scanner,String palavra, Estoque10 estoque10 ){
        while (true){
            System.out.print(palavra+":");
            palavra = scanner.nextLine().trim();
            if (estoque10.validandoString(palavra)){
                return Produto10.formatoNome(palavra);
            }
        }
    }

    public static int validandoQuantidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade < Produto10.QUANTIDADE_MINIMA){
                    System.out.println("Quantidade não pode ser menor que "+Produto10.QUANTIDADE_MINIMA);
                    continue;
                }
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPreCompra(Scanner scanner){
        while (true){
            try {
                System.out.print("Preço de compra:R$");
                double precoCompra = Double.parseDouble(scanner.nextLine());
                if (precoCompra < Produto10.PRECO_MINIMO_COMPRA){
                    System.out.println("Preço de compra for menor que "+Produto10.PRECO_MINIMO_COMPRA);
                    continue;
                }
                return precoCompra;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoPrecoVenda(Scanner scanner, double precoCompra){
        while (true){
            try {
                System.out.print("Preço de venda:R$");
                double precoVenda = Double.parseDouble(scanner.nextLine());
                if (precoVenda < precoCompra){
                    System.out.println("Preço de venda não pode ser menor que preço de compra.");
                    continue;
                }
                return precoVenda;
            }catch (NumberFormatException e){
                System.out.println("digite um valor válido.");
            }
        }
    }

    public void listaProdutos(){
        if (produto10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto10s.forEach(System.out::println);
        }
    }

    public void excluindoProduto(Scanner scanner){
        if (produto10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            try {
                System.out.print("Digite o código:");
                int codigo = Integer.parseInt(scanner.nextLine());
                Produto10 produto10 = produto10s.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
                if (produto10 != null){
                    produto10s.remove(produto10);
                    System.out.println("Produto removido com sucesso.");
                }else {
                    System.out.println("Código não encontrado.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void pesquisandoPOrNome(Scanner scanner){
        if (produto10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Digite o nome do produto: ");
            String nome = scanner.nextLine();
            Produto10 produto10 = produto10s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (produto10 !=null){
                System.out.println("___________________________________");
                System.out.println("Nome:"+produto10.getNome());
                System.out.println("Categoria:"+produto10.getCategoria());
                System.out.println("Quantidade:"+produto10.getQuantidade());
                System.out.println("Preço compra:R$"+produto10.getPrecoCompra());
                System.out.println("Preço venda:R$"+produto10.getPrecoVenda());
                System.out.println("Fornecedor:"+produto10.getFornecedor());
                System.out.println("___________________________________");
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public void retirarProdutoVencido(Scanner scanner){
        if (produto10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            produto10s.removeIf(produto10 -> produto10 instanceof ProdutosPereciveis10 &&
                    !((ProdutosPereciveis10)produto10).isValido());
            System.out.println("Produto vencido removido com sucesso.");
        }
    }

    public List<Produto10> getProduto10s() {
        return produto10s;
    }

    public void setProduto10s(List<Produto10> produto10s) {
        this.produto10s = produto10s;
    }
}
