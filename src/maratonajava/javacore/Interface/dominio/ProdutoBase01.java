package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase01;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase01;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase01;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase01;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase01 implements Produtos01{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase01(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase01();
        }
    }

    public static String formatoNome(String nome){
        return Arrays.stream(nome.toLowerCase().split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1)).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase01.MENOR_PRECO){
            throw new PrecoProdutoBase01();
        }
    }

    public static int validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase01.MENOR_ESTOQUE){
            throw new QuantidadeProdutoBase01();
        }
        return quantidade;
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase01.ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase01();
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
        this.nome = formatoNome(nome);
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
        this.quantidade -= validacaoQuantidade(quantidade);
        verificarEstoqueMinimo();
    }

    @Override
    public void verificarEstoqueMinimo() {
        if (quantidade <= estoqueMinimo){
            System.out.println("Alerta!!! "+nome+" está com estoque abaixo do mínimo permitido.");
        }
    }

    @Override
    public double calcularValorTotal(){
        return preco * quantidade;
    }
}
