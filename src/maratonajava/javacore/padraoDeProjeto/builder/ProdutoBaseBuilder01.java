package academy.devdojo.maratonajava.javacore.padraoDeProjeto.builder;

import academy.devdojo.maratonajava.javacore.Interface.dominio.Produto34;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Produtos34;
import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase34;

public class ProdutoBaseBuilder01 implements Produtos34 {
    private final String nome;
    private final double preco;
    private final int quantidade;
    private final int estoqueMinimo;

    private ProdutoBaseBuilder01(String nome, double preco, int quantidade, int estoqueMinimo) {
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
        if (nome == null || nome.isEmpty() || !nome.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new NomeProdutoBase34();
        }
    }

    public static void validacaoValor(double preco){
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
            System.out.println("Erro, quantidade em estoque abaixo do permitido.");
        }
    }

    @Override
    public String toString() {
        return "ProdutoBaseBuilder01{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }

    public static final class ProdutoBuilder01 {
        private String nome;
        private double preco;
        private int quantidade;
        private int estoqueMinimo;

        private ProdutoBuilder01() {
        }


//Instanciar o builder de forma clara, legível e sem expor diretamente o new ProdutoBuilder01() no código cliente.
        public static ProdutoBuilder01 aProdutoBaseBuilder01() {
            return new ProdutoBuilder01();
        }

        public ProdutoBuilder01 nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ProdutoBuilder01 preco(double preco) {
            this.preco = preco;
            return this;
        }

        public ProdutoBuilder01 quantidade(int quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ProdutoBuilder01 estoqueMinimo(int estoqueMinimo) {
            this.estoqueMinimo = estoqueMinimo;
            return this;
        }

        public ProdutoBaseBuilder01 build() {
            ProdutoBaseBuilder01.validacaoNome(nome);
            ProdutoBaseBuilder01.validacaoValor(preco);
            ProdutoBaseBuilder01.validacaoQuantidade(quantidade);
            ProdutoBaseBuilder01.validacaoEstoqueMinimo(estoqueMinimo);
            return new ProdutoBaseBuilder01(nome, preco, quantidade, estoqueMinimo);
        }

//        Ele constrói e retorna um objeto do tipo ProdutoBaseBuilder01, usando os valores acumulados
//        nas chamadas anteriores (como nome(), preco(), quantidade(), estoqueMinimo()).
//        A ideia é permitir a criação de objetos complexos passo a passo, mantendo o código limpo e legível.

    }

}
