package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido07 extends IllegalArgumentException {
    public CategoriaProdutoInvalido07() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
