package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutoComEstoqueMinimo11 extends Produto11{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo11(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static final int ESTOQUE_MINIMO = 50;
    public static final String TEXTO_ESTOQUE_MINIMO ="Estoque mínimo não pode ser menor que "+ESTOQUE_MINIMO+".";

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException(TEXTO_ESTOQUE_MINIMO);
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public static ProdutoComEstoqueMinimo11 validandoEstoqueMinimo(Scanner scanner, int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        int estoqueMinimo = 0;
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < ESTOQUE_MINIMO){
                    System.out.println(TEXTO_ESTOQUE_MINIMO);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new ProdutoComEstoqueMinimo11(codigo, nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|Estoque mínimo: "+estoqueMinimo);
    }
}
