package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto22;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto22;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto22;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto22 implements Vendavel22{
    private String nome;
    private double preco;
    private int estoque;

    public Produto22(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProduto22();
        }
    }

    public static String formatoNome(String nome){
        return Arrays.stream(nome.toLowerCase().split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1)).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto22.MENOR_PRECO){
            throw new PrecoProduto22();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto22.MENOR_ESTOQUE){
            throw new EstoqueProduto22();
        }
    }

    @Override
    public void exibirInfo() {
        System.out.println("Produto:"+nome+" |Preço:"+preco+" |Quantidade em estoque:"+estoque);
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoEstoque(estoque);
        this.nome = formatoNome(nome);
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

    public boolean retirarEstoque(int quantidade){
        if (quantidade > estoque){
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public int reporEstoque(int quantidade){
        return estoque += quantidade;
    }
}

