package academy.devdojo.maratonajava.javacore.padraoDeProjeto.builder;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Produtos34;
import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase34;

public class ProdutoBaseBuilder02 implements Produtos34 {
    private final String nome;
    private final double preco;
    private int quantidade;
    private int estoqueMinimo;

    public ProdutoBaseBuilder02(String nome, double preco, int quantidade, int estoqueMinimo) {
        validacaoNome(nome);
        validacaoValor(preco);
        validacaoQuantidade(quantidade);
        validacaoEstoqueMinimo(estoqueMinimo);
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^\\p{L}+( \\p{L})*$")){
            throw new NomeProdutoBase34();
        }
    }

    public static void validacaoValor(double valor){
        if (valor < PrecoProdutoBase34.MENOR_PRECO){
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

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void verificarEstoque(){
        if (quantidade < estoqueMinimo){
            System.out.println("Alerta, quantidade em estoque abaixo do estoque mínimo.");
        }
    }

    @Override
    public String toString() {
        return "ProdutoBaseBuilder02{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }

    public static final class ProdutoBuilder02 {
        private String nome;
        private double preco;
        private int quantidade;
        private int estoqueMinimo;

        private ProdutoBuilder02() {
        }

        public static ProdutoBuilder02 aProdutoBaseBuilder02() {
            return new ProdutoBuilder02();
        }

        public ProdutoBuilder02 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ProdutoBuilder02 preco(double preco) {
            this.preco = preco;
            return this;
        }

        public ProdutoBuilder02 quantidade(int quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ProdutoBuilder02 estoqueMinimo(int estoqueMinimo) {
            this.estoqueMinimo = estoqueMinimo;
            return this;
        }

        public ProdutoBaseBuilder02 build() {
            ProdutoBaseBuilder02.validacaoNome(nome);
            ProdutoBaseBuilder02.validacaoValor(preco);
            ProdutoBaseBuilder02.validacaoQuantidade(quantidade);
            ProdutoBaseBuilder02.validacaoEstoqueMinimo(estoqueMinimo)                                 ;
            return new ProdutoBaseBuilder02(nome, preco, quantidade, estoqueMinimo);
        }
    }
}
