package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase06;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase06;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase06;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase06;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase06 implements Produtos06{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase06(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase06();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase06.MENOR_PRECO){
            throw new PrecoProdutoBase06();
        }
    }

    public static int validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase06.MENOR_QUANTIDADE){
            throw new QuantidadeProdutoBase06();
        }
        return quantidade;
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase06.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase06();
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
        if (quantidade <= estoqueMinimo){
            System.out.println("Alerta."+nome+" está com está abaixo do mínimo.");
        }
    }
}
