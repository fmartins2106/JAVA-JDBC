package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase16;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase16;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase16;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase16;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase16 implements Produtos16{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase16(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase16();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPrecoProduto(double preco){
        if (preco < PrecoProdutoBase16.MENOR_PRECO_PRODUTO){
            throw new PrecoProdutoBase16();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase16.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeProdutoBase16();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase16.MENOR_ESTOQUE_MENIMO){
            throw new EstoqueMinimoProdutoBase16();
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
        validacaoPrecoProduto(preco);
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
            System.out.println("Alerta, quantidade em estoque está abaixo do estoque mínimo.");
        }
    }

    @Override
    public String toString() {
        return String.format("Nome: %s |Preço:R$%.2f |Quantidade: %d |Estoque mínimo: %s.",nome,preco,quantidade,estoqueMinimo);
    }
}
