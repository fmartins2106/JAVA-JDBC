package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase05;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase05;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase05;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase05;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase05 implements Produtos05{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase05(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase05();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase05.MENOR_PRECO){
            throw new PrecoProdutoBase05();
        }
    }

    public static int validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase05.MENOR_QUANTIDADE){
            throw new QuantidadeProdutoBase05();
        }
        return quantidade;
    }

    public static void validacaoEstoqueMimimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase05.ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase05();
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
        validacaoEstoqueMimimo(estoqueMinimo);
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public void aumentarQuantidade() {
        this.quantidade += validacaoQuantidade(quantidade);
    }

    @Override
    public void verificarEstoqueMinimo() {
        if (quantidade <= estoqueMinimo){
            System.out.println("Alerta."+nome+" está com estoque abaixo do estoque mínimo.");
        }
    }
}
