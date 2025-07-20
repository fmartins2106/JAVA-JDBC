package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido20 extends IllegalArgumentException {
    public CategoriaProdutoInvalido20() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
