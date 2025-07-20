package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutoComEstoqueMinimo12 extends Produto12{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo12(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static final int ESTOQUE_MINIMO = 0;
    public static final String MENSAGEM_ESTOQUE_INVALIDO = "Estoque não pode ser menor que zero.";

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException(MENSAGEM_ESTOQUE_INVALIDO);
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public static ProdutoComEstoqueMinimo12 validandoEstoqueMinimo(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        int estoqueMinimo = 0;
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                estoqueMinimo  = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < ESTOQUE_MINIMO){
                    System.out.println(MENSAGEM_ESTOQUE_INVALIDO);
                    continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new ProdutoComEstoqueMinimo12(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Estoque mínimo: "+estoqueMinimo);
    }
}
