package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueProduto32;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProduto32;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProduto32;

public class Produto32 implements Vendavel32{
    private String nome;
    private double preco;
    private int estoque;

    public Produto32(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProduto32();
        }
    }

    public static String formatoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras) {
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProduto32.MENOR_PRECO){
            throw new PrecoProduto32();
        }
    }

    public static void validacaoEstoque(int estoque){
        if (estoque < EstoqueProduto32.MENOR_ESTOQUE){
            throw new EstoqueProduto32();
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validacaoEstoque(estoque);
        this.estoque = estoque;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome:"+nome+" |Quantidade:"+estoque+" |Preço:R$"+preco);
    }

    public boolean retirarEstoque(int quantidade){
        if (quantidade > estoque){
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public int devolverEstoque(int quantidade){
        return estoque += quantidade;
    }
}
