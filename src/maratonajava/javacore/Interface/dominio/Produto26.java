package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto26;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto26;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto26;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto26 implements Vendavel26{
    private String nome;
    private double preco;
    private int estoque;

    public Produto26(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProduto26();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto26.MENOR_PRECO_PRODUTO){
            throw new PrecoProduto26();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto26.MENOR_QUANTIDADE_ESTOQUE){
            throw new EstoqueProduto26();
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
        validacaoEstoque(estoque);
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean diminuirEstoque(int quantidade){
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
