package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto42;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto42;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto42;

public class Produto42 implements Vendavel42{
    private String nome;
    private double preco;
    private int quantidade;

    public Produto42(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProduto42();
        }
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto42.MENOR_PRECO_PRODUTO){
            throw new PrecoProduto42();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < EstoqueProduto42.MENOR_QUANTIDADE_ESTOQUE){
            throw new EstoqueProduto42();
        }
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome:"+getNome()+" |Preço:R$"+getPreco()+" |Quantidade:"+getQuantidade());
    }

    public boolean retirarEstoque(int quantidadeCompra){
        if (quantidadeCompra > this.quantidade){
            System.out.println("Erro. Quantidade inválida.");
            return false;
        }
        this.quantidade -= quantidadeCompra;
        return true;
    }

    public int devolverEstoque(int quantidadeDevolvida){
        return this.quantidade += quantidadeDevolvida;
    }

//   @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Produto42 that = (Produto42) o;
//        return Double.compare(preco,that.preco) == 0 &&
//        nome.equalsIgnoreCase(that.nome);
//   }
//
//   @Override
//    public int hashCode(){
//        int result = nome.toLowerCase().hashCode();
//        result = 31 * result + Double.hashCode(preco);
//        return result;
//   }


}
