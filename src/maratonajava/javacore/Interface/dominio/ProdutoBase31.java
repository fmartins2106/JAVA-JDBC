
package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase31;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase31;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase31;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase31;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase31 implements Produtos31{
    private String nome;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;

    public ProdutoBase31(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase31();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase31.MENOR_PRECO_PRODUTO){
            throw new PrecoProdutoBase31();
        }
    }

    public static void validacaoQuantiade(int quantidade){
        if (quantidade < QuantidadeProdutoBase31.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeProdutoBase31();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase31.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase31();
        }
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoString(nome);
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validacaoPreco(preco);
        this.preco = preco;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantiade(quantidade);
        this.quantidade = quantidade;
    }

    @Override
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        validacaoEstoqueMinimo(estoqueMinimo);
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public void verificarEstoqueMinimo() {
        if (quantidade < estoqueMinimo){
            System.out.println("Alerta. Valor em estoque está abaixo do estoque mínimo.");
        }
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |Preço:R$%.2f |Quantidade:%d |Estoque mínimo: %d.",
                nome, preco,quantidade,estoqueMinimo);
    }
}
