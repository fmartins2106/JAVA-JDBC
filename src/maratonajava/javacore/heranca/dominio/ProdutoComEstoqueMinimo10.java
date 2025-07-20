package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.security.DigestOutputStream;
import java.util.Scanner;

public class ProdutoComEstoqueMinimo10 extends Produto10{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo10(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setEstoqueMinimo(estoqueMinimo);
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public static final int ESTOQUE_MINIMO =50;
    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException("Estoque mínimo não pode ser menor que "+ESTOQUE_MINIMO);
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public static ProdutoComEstoqueMinimo10 validandoEstoqueMinimo(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        int estoqueMinimo =0;
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < ESTOQUE_MINIMO){
                    System.out.println("Estoque mínimo não pode ser menor que "+ESTOQUE_MINIMO);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new ProdutoComEstoqueMinimo10(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Estoque mínimo: "+estoqueMinimo);
    }
}
