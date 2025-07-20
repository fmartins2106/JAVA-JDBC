package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto34;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto34;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto34;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto34 implements Vendavel34{
    private String nome;
    private double preco;
    private int estoque;

    public Produto34(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new NomeProduto34();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto34.MENOR_PRECO){
            throw new PrecoProduto34();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto34.MENOR_ESTOQUE){
            throw new EstoqueProduto34();
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validacaoEstoque(estoque);
        this.estoque = estoque;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Produto:"+nome+" |Quantidade:"+estoque+" |R$"+preco);
    }

    public boolean retirarEstoque(int quantidade){
        if (quantidade > estoque){
            System.out.println(">>>Quantidade inválida.");
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public int devolverEstoque(int quantidade){
        return estoque += quantidade;
    }
}
