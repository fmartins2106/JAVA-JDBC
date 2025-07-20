package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido27 extends IllegalArgumentException {
    public CategoriaProdutoInvalido27() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
