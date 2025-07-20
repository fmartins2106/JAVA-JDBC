package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException28;
import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase28;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase28;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase28;
import academy.devdojo.maratonajava.javacore.excessoes.ValorMercadoInvalidaException35;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase28 implements Produtos28{
    protected String nome;
    protected double valor;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase28(String nome, double valor, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setValor(valor);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNomeProduto(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase28();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoValorProduto(double valor){
        if (valor < ValorFaturaException28.MENOR_VALOR_FATURA){
            throw new ValorMercadoInvalidaException35();
        }
    }

    public static void validacaoQuantidadeProduto(int quantidade){
        if (quantidade < QuantidadeProdutoBase28.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeProdutoBase28();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase28.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase28();
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        validacaoValorProduto(valor);
        this.valor = valor;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidadeProduto(quantidade);
        this.quantidade = quantidade;
    }

    @Override
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        validacaoEstoqueMinimo(estoqueMinimo);
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public void verificarEstoque() {
        if (estoqueMinimo > quantidade){
            System.out.println("Alerta. Quantidade em estoque está abaixo do estoque mínimo.");
        }
    }
}
