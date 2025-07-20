package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido13 extends IllegalArgumentException {
    public CategoriaProdutoInvalido13() {
        super("Campo categoria não pode ficar vazio ou conter caracteres.");
    }
}
