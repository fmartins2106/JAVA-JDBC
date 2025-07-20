package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase02;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase02;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase02;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase02;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase02 implements Produtos02{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase02(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9-]+( [\\p{L}0-9-]+)*$")){
            throw new NomeProdutoBase02();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase02.MENOR_PRECO_PRODUTO){
            throw new PrecoProdutoBase02();
        }
    }

    public static int validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase02.MENOR_ESTOQUE){
            throw new QuantidadeProdutoBase02();
        }
        return quantidade;
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase02.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase02();
        }
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoString(nome);
    }

    public void setPreco(double preco) {
        validacaoPreco(preco);
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        validacaoEstoqueMinimo(estoqueMinimo);
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public void aumentarQuantidade(int quantidade) {
        this.quantidade += validacaoQuantidade(quantidade);
        verificarEstoqueMinimo();
    }

    @Override
    public void diminuirQuantidade(int quantidade) {
        this.estoqueMinimo -= validacaoQuantidade(quantidade);
        verificarEstoqueMinimo();
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
