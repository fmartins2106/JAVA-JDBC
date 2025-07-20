package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido02 extends IllegalArgumentException {
    public CategoriaProdutoInvalido02() {
        super("Campo categoria não pode ficar vazio ou conter caracteres.");
    }
}
