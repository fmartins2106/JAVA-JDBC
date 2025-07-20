package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutoComEstoqueMinimo17 extends Produto17{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo17(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static final int ESTOQUE_MINIMO = 50;

    public void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException(Produto17.MensagemValidacaoProduto17.ERRO_ESTOQUE_MINIMO.getDescricao());
        }
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        validacaoEstoqueMinimo(estoqueMinimo);
        this.estoqueMinimo = estoqueMinimo;
    }

    public static int validandoEstoqueMinimo(Scanner scanner){
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < ESTOQUE_MINIMO){
                    System.out.println(Produto17.MensagemValidacaoProduto17.ERRO_ESTOQUE_MINIMO.getDescricao());
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static ProdutoComEstoqueMinimo17 validandoDadosEstoqueMinimo(Scanner scanner, int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor){
        int estoqueMinimo = validandoEstoqueMinimo(scanner);
        return new ProdutoComEstoqueMinimo17(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Estoque mínimo: %d ",estoqueMinimo);
    }
}
