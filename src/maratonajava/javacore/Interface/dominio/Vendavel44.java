package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase34;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase34;

public interface Vendavel44 {
    String getNome();
    double getPreco();
    void exibirInfo();

    abstract class ProdutoBase34 implements Produtos34 {
        private String nome;
        private double preco;
        private int quantidade;
        private int estoqueMinimo;

        protected ProdutoBase34() {
            // Construtor protegido para uso no builder
        }

        public static ProdutoBase34Builder builder() {
            return new ProdutoBase34Builder();
        }

        public static void validacaoNome(String nome) {
            if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")) {
                throw new NomeProdutoBase34();
            }
        }

        public static String formatoString(String nome) {
            String[] palavras = nome.toLowerCase().split("\\s+");
            StringBuilder nomeFormatado = new StringBuilder();
            for (String palavra : palavras) {
                nomeFormatado.append(palavra.substring(0, 1).toUpperCase())
                             .append(palavra.substring(1))
                             .append(" ");
            }
            return nomeFormatado.toString().trim();
        }

        public static void validacaoPreco(double preco) {
            if (preco < PrecoProdutoBase34.MENOR_PRECO) {
                throw new PrecoProdutoBase34();
            }
        }

        public static void validacaoQuantidade(int quantidade) {
            if (quantidade < QuantidadeProdutoBase34.MENOR_QUANTIDADE) {
                throw new QuantidadeProdutoBase34();
            }
        }

        public static void validacaoEstoqueMinimo(int estoqueMinimo) {
            if (estoqueMinimo < EstoqueMinimoProdutoBase34.MENOR_ESTOQUE_MINIMO) {
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
            if (quantidade < estoqueMinimo) {
                System.out.println("Alerta. Quantidade em estoque está abaixo do estoque mínimo.");
            }
        }

        @Override
        public String toString() {
            return String.format("Nome:%s |Preço:R$%.2f |Quantidade:%d |Estoque mínimo:%d",
                    this.nome, this.preco, this.quantidade, this.estoqueMinimo);
        }

        public static class ProdutoBase34Builder {
            private final ProdutoBase34 produto;

            public ProdutoBase34Builder() {
                this.produto = new ProdutoBase34() {};
            }

            public ProdutoBase34Builder nome(String nome) {
                produto.setNome(nome);
                return this;
            }

            public ProdutoBase34Builder preco(double preco) {
                produto.setPreco(preco);
                return this;
            }

            public ProdutoBase34Builder quantidade(int quantidade) {
                produto.setQuantidade(quantidade);
                return this;
            }

            public ProdutoBase34Builder estoqueMinimo(int estoqueMinimo) {
                produto.setEstoqueMinimo(estoqueMinimo);
                return this;
            }

            public ProdutoBase34 build() {
                return produto;
            }
        }
    }
}
