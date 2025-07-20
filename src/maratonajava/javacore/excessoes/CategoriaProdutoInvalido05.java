package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido05 extends IllegalArgumentException {
    public CategoriaProdutoInvalido05() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
