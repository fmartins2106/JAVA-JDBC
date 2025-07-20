package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto43;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto43;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto43;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto43 implements Vendavel43{
    private String nome;
    private double preco;
    private int quantidade;

    public Produto43(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public static void validacaoNomeProduto(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProduto43();
        }
    }

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto43.MENOR_PRECO_PRODUTO){
            throw new PrecoProduto43();
        }
    }

    public static void valdiacaoQuantidade(int quantidade){
        if (quantidade < EstoqueProduto43.MENOR_QUANTIDADE_ESTOQUE){
            throw new EstoqueProduto43();
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
        validacaoPreco(preco);
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        valdiacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome:"+this.nome+" |Quantidade:"+this.quantidade+" |Preco:R$"+this.preco);
    }

    public boolean retirarEstoque(int quantidadeComprada){
        if (quantidadeComprada > quantidade){
            System.out.println("Quantidade inválida. Verifique.");
            return false;
        }
        quantidade -= quantidadeComprada;
        return true;
    }

    public int devolverEstoque(int quantidadeComprada){
        return quantidade += quantidadeComprada;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto43 that = (Produto43) o;
        return Double.compare(preco,that.preco) == 0 &&
                nome.equalsIgnoreCase(that.nome);
    }

    @Override
    public int hashCode(){
        int result = nome.toLowerCase().hashCode();
        result = 31 * result + Double.hashCode(preco);
        return result;
    }
}
