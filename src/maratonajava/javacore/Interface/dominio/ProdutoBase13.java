package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase13;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase13;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase13;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase13;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase13 implements Produtos13{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase13(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null ||  nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase13();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase13.MENOR_PRECO){
            throw new PrecoProdutoBase13();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase13.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeProdutoBase13();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMInimo){
        if (estoqueMInimo < EstoqueMinimoProdutoBase13.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase13();
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
    public void verificarEstoqueMinimo() {
        if (estoqueMinimo > quantidade){
            System.out.println("Alerta, quantidade em estoque está abaixo do mínimo.");
        }
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |Preço:R$%.2f |Quantidade: %d |Estoque mínimo: %d.",
                nome,preco,quantidade,estoqueMinimo);
    }
}
