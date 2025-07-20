package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto41;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto41;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto41;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto41 implements Vendavel41{
    private String nome;
    private double preco;
    private int estoque;

    public Produto41(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9])*$")){
            throw new NomeProduto41();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto41.MENOR_PRECO_PRODUTO){
            throw new PrecoProduto41();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto41.ESTOQUE_MINIMO){
            throw new EstoqueProduto41();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
         validacaoNome(nome);
        this.nome = formatoString(nome);
    }

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
        System.out.println("Nome:"+nome+" |Quantidade:"+estoque+" |Preço:R$"+preco);
    }

    public boolean retirarEstoque(int quantidade){
        if (quantidade > estoque){
            System.out.println("Quantidade inválida.");
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public int devolverEstoque(int quantidade){
        return estoque += quantidade;
    }

}
