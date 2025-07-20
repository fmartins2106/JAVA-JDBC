package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutoComEstoqueMinimo09 extends Produto09 {
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo09(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public static final int ESTOQUE_MINIMO=50;
    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException("Estoque mínimo não pode ser menor que 50.");
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public static ProdutoComEstoqueMinimo09 validandoEstoqueMinimo(Scanner scanner, int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        int estoqueMinimo;
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < 50){
                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
        return new ProdutoComEstoqueMinimo09(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Estoque mínimo: "+estoqueMinimo);
    }
}
