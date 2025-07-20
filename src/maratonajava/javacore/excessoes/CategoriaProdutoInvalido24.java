package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido24 extends IllegalArgumentException {
    public CategoriaProdutoInvalido24() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
