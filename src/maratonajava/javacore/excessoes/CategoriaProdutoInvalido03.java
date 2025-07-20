package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido03 extends IllegalArgumentException {
    public CategoriaProdutoInvalido03() {
        super("Campo categoria não pode ficar vazio ou conter caracteres.");
    }
}
