package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido23 extends IllegalArgumentException {
    public CategoriaProdutoInvalido23() {
        super("Campo categoria não pode ficar vazio ou conter caracteres.");
    }
}
