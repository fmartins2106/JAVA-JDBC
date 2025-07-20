package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido17 extends IllegalArgumentException {
    public CategoriaProdutoInvalido17() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
