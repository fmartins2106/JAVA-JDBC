package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeDadosProduto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DadosProduto04 implements NovosProdutos04 {
    private String nome;
    private double preco;
    private int quantidade;
    private String descricao;

    public DadosProduto04(String nome, double preco, int quantidade, String descricao) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setDescricao(descricao);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
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

    public static String formatoString(String palavras){
        return Arrays.stream(palavras.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        + palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    @Override
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
        return String.format("Produto:"+this.nome+" |Preço:R$"+this.preco+" |Quantidade:"+this.quantidade+" |Descrição:"+this.descricao);
    }



}
