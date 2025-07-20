package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeDadosProduto;

public class DadosProduto01 implements NovosProdutos01 {
    private String nome;
    private double preco;
    private int quantidade;
    private String descricao;

    public DadosProduto01(String nome, double preco, int quantidade, String descricao) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setDescricao(descricao);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeDadosProduto();
        }
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoDadosProduto.MENOR_PRECO){
            throw new PrecoDadosProduto();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeDadosProduto.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeDadosProduto();
        }
    }

    public static void validacaoDescricao(String descricao){
        if (descricao == null || descricao.isEmpty() || !descricao.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new DescricaoProdutoDadosProduto();
        }
    }

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

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        validacaoDescricao(descricao);
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("Preço:R$"+this.preco+" |Quantidade:"+this.quantidade+" |Descrição:"+descricao);
    }
}
