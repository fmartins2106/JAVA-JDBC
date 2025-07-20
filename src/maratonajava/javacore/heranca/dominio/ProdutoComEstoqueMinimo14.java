package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutoComEstoqueMinimo14 extends Produto14{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo14(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static final int ESTOQUE_MINIMO = 50;
    public static final String MENSAGEM_ERRO_ESTOQUE_MINIMO = "Estoque mínimo não pode ser menor que 50 unidades";

    private void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_ESTOQUE_MINIMO);
        }
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        validacaoEstoqueMinimo(estoqueMinimo);
        this.estoqueMinimo = estoqueMinimo;
    }

    public static int validacaoEstoqueMinimo(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Estoque mínimo:");
                int estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < ESTOQUE_MINIMO) {
                    System.out.println(MENSAGEM_ERRO_ESTOQUE_MINIMO);
                    continue;
                }
                return estoqueMinimo;
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido.");
            }
        }
    }
    public static ProdutoComEstoqueMinimo14 validandoEstoqueMinimo(Scanner scanner, int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor){
        int estoqueMinimo = validacaoEstoqueMinimo(scanner);
        return new ProdutoComEstoqueMinimo14(codigo,nome,categoria, quantidade,precoCompra,precoVenda,fornecedor, estoqueMinimo);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Estoque mínimo: "+estoqueMinimo);
    }
}
