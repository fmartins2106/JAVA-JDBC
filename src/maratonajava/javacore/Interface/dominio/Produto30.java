package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto30;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto30;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto30;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto30 implements Vendavel30{
    private String nome;
    private double preco;
    private int estoque;

    public Produto30(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProduto30();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto30.MENOR_PRECO_PRODUTO){
            throw new PrecoProduto30();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto30.MENOR_ESTOQUE){
            throw new EstoqueProduto30();
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("Produto:"+nome+" |Preço:"+preco+" |Quantidade:"+estoque);
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoString(nome);
    }

    public void setPreco(double preco) {
        validacaoPreco(preco);
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        validacaoEstoque(estoque);
        this.estoque = estoque;
    }

    public boolean retirarEstoque(int quantidade){
        if (quantidade > estoque){
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public int retornarEstoque(int quantidade){
        return estoque += quantidade;
    }

}
