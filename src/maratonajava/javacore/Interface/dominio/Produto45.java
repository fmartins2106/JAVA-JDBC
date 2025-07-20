package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto45;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto45;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto45;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Produto45 implements Vendavel45{
    private String nome;
    private double preco;
    private int estoque;

    public Produto45(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNomeProduto(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProduto45();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPrecoProduto(double preco){
        if (preco < PrecoProduto45.MENOR_PRECO_PRODUTO){
            throw new PrecoProduto45();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto45.MENOR_QUANTIDADE_ESTOQUE){
            throw new EstoqueProduto45();
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validacaoEstoque(estoque);
        this.estoque = estoque;
    }

    public boolean retirarEstoque(int quantidade){
        if (quantidade > estoque){
            System.out.println("Erro. Quantidade inválida.");
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public int devolverParaEstoque(int quantidade){
        return estoque += quantidade;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome:"+this.nome+" |Preço:R$"+this.preco+" |Quantidade:"+this.estoque);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto45 produto45 = (Produto45) o;
        return Double.compare(preco, produto45.preco) == 0 && nome.equalsIgnoreCase(produto45.nome);
    }

    @Override
    public int hashCode() {
        int result = nome.toLowerCase().hashCode();
        result = 31 * result + Double.hashCode(preco);
        return result;
    }
}
