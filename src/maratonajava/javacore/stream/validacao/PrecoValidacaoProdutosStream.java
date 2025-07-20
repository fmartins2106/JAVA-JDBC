package academy.devdojo.maratonajava.javacore.stream.validacao;

public class PrecoValidacaoProdutosStream extends IllegalArgumentException {
    public static final double MENOR_PRECO = 0;
    public PrecoValidacaoProdutosStream() {
        super(String.format("Preço não pode ser menor que R$%.2f",MENOR_PRECO));
    }
}
