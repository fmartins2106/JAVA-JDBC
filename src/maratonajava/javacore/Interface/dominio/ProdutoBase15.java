package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase15;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase15;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase15;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase15;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase15 implements Produtos15{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase15(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase15();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
                +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase15.MENOR_PRECO){
            throw new PrecoProdutoBase15();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase15.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeProdutoBase15();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase15.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase15();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoString(nome);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validacaoPreco(preco);
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

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
            System.out.println("Alerta. Quantidade em estoque abaixo do estoque mínimo recomendado.");
        }
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |Preço:R$%.2f |Quantidade: %d |Estoque mínimo: %d",nome,preco,quantidade, estoqueMinimo);
    }

}
