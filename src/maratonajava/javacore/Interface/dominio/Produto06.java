package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto06 implements Vendavel06{
    private String nome;
    private double preco;
    private int estoque;

    public Produto06(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{P}0-9]+( [\\p{L}0-9]}+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoProduto06.NOME.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    private static final double MENOR_PRECO = 0;

    public static void validacaoPreco(double preco){
        if (preco < MENOR_PRECO){
            throw new IllegalArgumentException(MensagensValidacaoProduto06.PRECO.getDescricaoFormatada(MENOR_PRECO));
        }
    }

    private static final int ESTOQUE_MINIMO = 0;

    public static void validacaoEstoque(int estoque){
        if (estoque < ESTOQUE_MINIMO){
            throw new IllegalArgumentException(MensagensValidacaoProduto06.ESTOQUE.getDescricaoFormatada(ESTOQUE_MINIMO));
        }
    }

    @Override
    public void exibirInfo(){
        System.out.println("Produto: "+nome+" |Preço:R$"+preco+" |Quantidade:"+estoque);
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validacaoEstoque(estoque);
        this.estoque = estoque;
    }

    public enum MensagensValidacaoProduto06{
        NOME("Campo nome não pode ser vazio ou conter caracteres."),
        PRECO("Preço não pode ser menor que %.2f."),
        ESTOQUE("Estoque não pode ser menor que %d.");

        private final String descricao;

        MensagensValidacaoProduto06(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(int...valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

    public boolean redizirEstoque(int quantidade){
        if (quantidade > estoque){
            System.out.println("Estoque insuficiente.");
            return false;
        }
        estoque -= quantidade;
        return true;
    }
}
