package academy.devdojo.maratonajava.javacore.stream.validacao;

public class NomeValidacaoProdutoStream extends IllegalArgumentException {
    public NomeValidacaoProdutoStream() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
