package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutoComEstoqueMinimo16 extends Produto16 {
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo16(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        this.estoqueMinimo = estoqueMinimo;
    }

    public static final int ESTOQUE_MINIMO=50;

    public void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException(MensagemValidacao.ERRO_ESTOQUE_MINIMO.getDescricao());
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
        int estoqueMinimo = 0;
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < ESTOQUE_MINIMO){
                    System.out.println(MensagemValidacao.ERRO_ESTOQUE_MINIMO.getDescricao());
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static ProdutoComEstoqueMinimo16 validandoDadosEstoqueMinimo(Scanner scanner, int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor){
        int estoqueMinimo = validandoEstoqueMinimo(scanner);
        return new ProdutoComEstoqueMinimo16(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Estoque mínimo: "+estoqueMinimo);
    }
}
