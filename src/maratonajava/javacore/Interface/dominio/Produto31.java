package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto31;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto31;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto31;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto31 implements Vendavel31{
    private String nome;
    private double preco;
    private int estoque;

    public Produto31(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProduto31();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto31.MENOR_PRECO){
            throw new PrecoProduto31();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto31.MENOR_ESTOQUE){
            throw new EstoqueProduto31();
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
        System.out.println("Nome:"+nome+" |PreçoR$"+preco+" |Quantidade:"+estoque);
    }

    public boolean retirarCarrinho(int quantidade){
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
