package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido33 extends IllegalArgumentException {
    public CategoriaProdutoInvalido33() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
