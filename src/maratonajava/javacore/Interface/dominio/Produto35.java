package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto35;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto35;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto35;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto35 implements Vendavel35 {
    private String nome;
    private double preco;
    private int estoque;

    public Produto35(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")) {
            throw new NomeProduto35();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco ( double preco){
        if (preco < PrecoProduto35.MENOR_PRECO) {
            throw new PrecoProduto35();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto35.MENOR_ESTOQUE){
            throw new EstoqueProduto35();
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
        System.out.println("Produto:"+nome+ " |Preço:R$"+preco+" |Quantidade:"+estoque);
    }

    public boolean diminuirEstoque(int quantidade){
        if (quantidade > estoque){
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public int retornarAoEstoque(int quantidade){
        return estoque += quantidade;
    }
}