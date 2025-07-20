package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.text.NumberFormat;
import java.util.Scanner;

public class ProdutoComEstoqueMinimo07 extends Produto07{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo07(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setEstoqueMinimo(estoqueMinimo);
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    private static final int ESTOQUE_MINIMO = 50;
    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException("Estoque mínimo não pode ser menor que 50.");
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public static ProdutoComEstoqueMinimo07 validandoEstoqueMinimo(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        int estoqueMinimo=0;
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < ESTOQUE_MINIMO){
                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new ProdutoComEstoqueMinimo07(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    public String toString(){
        return super.toString()+String.format("|Estoque mínimo: "+estoqueMinimo);
    }
}
