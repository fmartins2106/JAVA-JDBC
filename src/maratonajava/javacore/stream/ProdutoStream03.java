package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.stream.validacao.NomeValidacaoProdutoStream;
import academy.devdojo.maratonajava.javacore.stream.validacao.PrecoValidacaoProdutosStream;
import academy.devdojo.maratonajava.javacore.stream.validacao.QuantidadeValidacaoProdutoStream;

import java.util.Objects;

public class ProdutoStream03 {
    private String nome;
    private int quantidade;
    private double preco;
    private Categoria03 categoria03;

    public ProdutoStream03(String nome, int quantidade, double preco, Categoria03 categoria03) {
        setNome(nome);
        setQuantidade(quantidade);
        setPreco(preco);
        this.categoria03 = categoria03;
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeValidacaoProdutoStream();
        }
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoValidacaoProdutosStream.MENOR_PRECO){
            throw new PrecoValidacaoProdutosStream();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeValidacaoProdutoStream.QUANTIDADE_MINIMA){
            throw new QuantidadeValidacaoProdutoStream();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validacaoPreco(preco);
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoStream03 that = (ProdutoStream03) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    public Categoria03 getCategoria03() {
        return categoria03;
    }

    @Override
    public String toString() {
        return "ProdutoStream03{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", categoria=" + categoria03 +
                '}';
    }
}
