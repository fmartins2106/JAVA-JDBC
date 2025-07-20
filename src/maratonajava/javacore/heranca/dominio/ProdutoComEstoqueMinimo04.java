package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutoComEstoqueMinimo04 extends Produto04{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo04(int codigo, String nome, String categoria, double precoCompra, double precoVenda, int quantidade, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, precoCompra, precoVenda, quantidade, fornecedor);
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < 50){
            throw new IllegalArgumentException("Estoque mínimo não pode ser menor que 50.");
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public static ProdutoComEstoqueMinimo04 validandoEstoqueMinimo(Scanner scanner, int codigo, String nome, String categoria, double precoCompra, double precoVenda, int quantidade, String fornecedor){
        int estoqueMinimo = 0;
        while (true){
            try {
                System.out.print("Digite o estoque mínimo:");
                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < 50){
                    System.out.println("Estoque mínimo não pode ser menor que 50.");
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.print("Digite um valor válido.");
            }
        }
        return new ProdutoComEstoqueMinimo04(codigo,nome,categoria,precoCompra,precoVenda,quantidade,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString(){
        return super.toString()+String.format(" |Estoque mínimo: %d"+estoqueMinimo);
    }
}
