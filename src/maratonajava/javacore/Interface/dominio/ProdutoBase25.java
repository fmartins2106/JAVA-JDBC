package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase25;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase25;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase25;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase25;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProdutoBase25 implements Produtos25{
    private String nome;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;

    public ProdutoBase25(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase25();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase25.MENOR_VALOR_PRODUTO){
            throw new PrecoProdutoBase25();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase25.MENOR_QUANTIDE_ESTOQUE){
            throw new QuantidadeProdutoBase25();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase25.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase25();
        }
    }


    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = nome;
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
        validacaoQuantidade(quantidade);
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
        if (estoqueMinimo > quantidade){
            System.out.println("Alerta. Quantidade em estoque menor que estoque mínimo. Verifique.");
        }
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |Preço:R$%.2f |Quantidade: %d |Estoque mínimo: %d.",this.nome,this.preco,this.quantidade,this.estoqueMinimo);
    }
}
