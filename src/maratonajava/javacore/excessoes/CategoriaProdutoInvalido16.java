package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido16 extends IllegalArgumentException {
    public CategoriaProdutoInvalido16() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
