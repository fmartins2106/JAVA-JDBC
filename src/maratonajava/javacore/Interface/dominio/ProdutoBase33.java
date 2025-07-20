package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase33;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase33;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase33;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase33;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase33 implements Protudo33 {
    private String nome;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;

    public ProdutoBase33(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNomeProduto(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase33();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPrecoProduto(double preco){
        if (preco < PrecoProdutoBase33.MENOR_PRECO_PRODUTO){
            throw new PrecoProdutoBase33();
        }
    }

    public static void validacaoQuantidadeProduto(int quantidade){
        if (quantidade < QuantidadeProdutoBase33.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeProdutoBase33();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase33.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase33();
        }
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNomeProduto(nome);
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
        validacaoQuantidadeProduto(quantidade);
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
        return String.format("Nome: %s |Preço:R$%.2f |Quantidade:%d |Estoque mínimo:%d.",this.nome,this.preco,
                this.quantidade,this.estoqueMinimo);
    }
}
