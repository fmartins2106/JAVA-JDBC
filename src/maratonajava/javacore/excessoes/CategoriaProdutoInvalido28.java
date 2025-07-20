package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido28 extends IllegalArgumentException {
    public CategoriaProdutoInvalido28() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
