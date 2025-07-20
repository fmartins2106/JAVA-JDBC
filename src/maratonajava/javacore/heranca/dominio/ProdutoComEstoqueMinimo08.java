package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutoComEstoqueMinimo08 extends Produto08{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo08(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setEstoqueMinimo(estoqueMinimo);
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    private static final int ESTOQUE_MINIMO=50;
    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException("Estoque mínimo não pode ser menor que 50.");
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public static ProdutoComEstoqueMinimo08 validandoEstoqueMinimo(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        int estoqueMinimo = 0;
        while (true){
            try {
                System.out.print("Digite estoque minimo");
                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < 50){
                    System.out.println("Estoque mínimo não pode ser menor qur 50");
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new ProdutoComEstoqueMinimo08(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Estoque mínimo:"+ estoqueMinimo);
    }
}
