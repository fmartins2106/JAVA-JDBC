package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto36;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase10;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto36;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase08;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto36 implements Vendavel36{
    private String nome;
    private double preco;
    private int estoque;

    public Produto36(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase10();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto36.MENOR_PRECO){
            throw new PrecoProdutoBase08();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto36.MENOR_ESTOQUE){
            throw new EstoqueProduto36();
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("Produto:"+nome+" |Preço:R$"+preco+" |Quantidade:"+estoque);
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validacaoPreco(preco);
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validacaoEstoque(estoque);
        this.estoque = estoque;
    }

    public boolean retirarProduto(int quantidade){
        if (quantidade > estoque){
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public int devolverEstoque(int quantidade){
        return estoque += quantidade;
    }

}
