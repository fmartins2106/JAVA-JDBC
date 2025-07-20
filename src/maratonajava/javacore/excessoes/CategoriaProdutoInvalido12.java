package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido12 extends IllegalArgumentException {
    public CategoriaProdutoInvalido12() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
