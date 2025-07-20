package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido25 extends IllegalArgumentException {
    public CategoriaProdutoInvalido25() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
