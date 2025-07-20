package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase03;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase03;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase03;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase03;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase03 implements Produtos03{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase03(String nome, double preco, int quantidade, int estoqueMinimo) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase03();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase03.MENOR_PRECO){
            throw new PrecoProdutoBase03();
        }
    }

    public static int validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase03.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeProdutoBase03();
        }
        return quantidade;
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase03.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase03();
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
    public void aumentarQuantidade(int quantidade) {
        this.quantidade += validacaoQuantidade(quantidade);
    }

    @Override
    public void verificarEstoqueMinimo() {
        if (quantidade <= estoqueMinimo){
            System.out.println("Alerta!!!"+nome+" está com estoque abaixo do permitido.");
        }
    }

    @Override
    public double calcularValorTotal() {
        return preco * quantidade;
    }
}
