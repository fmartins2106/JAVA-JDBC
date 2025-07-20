package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido26 extends IllegalArgumentException {
    public CategoriaProdutoInvalido26() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
