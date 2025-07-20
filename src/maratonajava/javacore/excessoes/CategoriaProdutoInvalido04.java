package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido04 extends IllegalArgumentException {
    public CategoriaProdutoInvalido04() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
