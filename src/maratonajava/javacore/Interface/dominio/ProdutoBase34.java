package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

public abstract class ProdutoBase34 implements Produtos34 {
    private String nome;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;

    public ProdutoBase34(String nome, double preco, int quantidade, int estoqueMinimo) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{all}0-9]+( [\\p{all}0-9]+)*$")){
            throw new NomeProdutoBase34();
        }
    }

    public static String formatoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras) {
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase34.MENOR_PRECO){
            throw new PrecoProdutoBase34();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase34.MENOR_QUANTIDADE){
            throw new QuantidadeProdutoBase34();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase34.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase34();
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

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidade(quantidade);
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
        if (quantidade < estoqueMinimo){
            System.out.println("Alerta. Quantidade em estoque está abaixo do estoque mínimo.");
        }
    }

    @Override
    public String toString() {
        return String.format("Nome:"+this.nome+" |Preço:R$"+this.preco+" |Quantidade:"+this.quantidade+" |Estoque mínimo:"+estoqueMinimo);
    }
}
