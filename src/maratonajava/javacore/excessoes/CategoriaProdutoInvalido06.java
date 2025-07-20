package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido06 extends IllegalArgumentException {
    public CategoriaProdutoInvalido06() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
