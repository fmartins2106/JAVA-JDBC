package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.Scanner;

public class ProdutosComEstoqueMinimo15 extends Produto15{
    private int estoqueMinimo;

    public ProdutosComEstoqueMinimo15(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String formecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, formecedor);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static final String MENSAGEM_ERRO_ESTOQUE_MIN = "Estoque não pode ser menor que 50.";
    public static final int ESTOQUE_MINIMO = 50;

    private void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < ESTOQUE_MINIMO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_ESTOQUE_MIN);
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
        int estoqueMinimo=0;
        while (true){
            try {
                System.out.print("Estoque mínimo:");
                estoqueMinimo = Integer.parseInt(scanner.nextLine());
                if (estoqueMinimo < ESTOQUE_MINIMO){
                    System.out.println(MENSAGEM_ERRO_ESTOQUE_MIN);
                    continue;
                }
                return estoqueMinimo;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static ProdutosComEstoqueMinimo15 validandoDadosEstoqueMinimo(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor){
        int estoqueMinimo = validandoEstoqueMinimo(scanner);

        return new ProdutosComEstoqueMinimo15(codigo, nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,estoqueMinimo);
    }

    @Override
    public String toString() {
        return super.toString()+String.format("Estoque mínima: %d", estoqueMinimo);
    }
    
}
