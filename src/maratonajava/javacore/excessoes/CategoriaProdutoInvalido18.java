package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido18 extends IllegalArgumentException {
    public CategoriaProdutoInvalido18() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
