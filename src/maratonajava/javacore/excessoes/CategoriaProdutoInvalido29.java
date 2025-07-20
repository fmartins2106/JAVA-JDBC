package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido29 extends IllegalArgumentException {
    public CategoriaProdutoInvalido29() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
