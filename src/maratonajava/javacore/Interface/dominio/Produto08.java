package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.Veiculo24;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto08 implements Vendavel08{
    private String nome;
    private double preco;
    private int estoque;

    public Produto08(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoProduto08.NOME.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }


    private static final double MENOR_PRECO = 0;

    public static void validacaoPreco(double preco){
        if (preco < MENOR_PRECO){
            throw new IllegalArgumentException(MensagensValidacaoProduto08.PRECO.getDescricaoFormatada(MENOR_PRECO));
        }
    }

    private static final int MENOR_ESTOQUE = 0;

    public static void validacaoEstoque(int estoque){
        if (estoque < MENOR_ESTOQUE){
            throw new IllegalArgumentException(MensagensValidacaoProduto08.ESTOQUE.getDescricaoFormatada(MENOR_ESTOQUE));
        }
    }

    @Override
    public void exibirInfo(){
        System.out.println("Nome:"+nome+" |PreçoR$"+preco+" |Estoque:"+estoque);
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
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

    public boolean diminuirEstoque(int quantidade){
        if (quantidade > estoque){
            System.out.println("Quantidade inválida. Verifique.");
            return false;
        }
        estoque -= quantidade;
        return true;
    }


    public enum MensagensValidacaoProduto08{
        NOME("Campo nome não pode ser vazio ou conte caracteres."),
        PRECO("Preço inválido. Preço não pode ser menor que R$%.2f."),
        ESTOQUE("Quantidade inválida. Quantidade não pode ser menor que %d.");

        private final String descricao;

        MensagensValidacaoProduto08(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }

}
