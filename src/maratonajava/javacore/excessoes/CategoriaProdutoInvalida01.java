package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalida01 extends IllegalArgumentException {
    public CategoriaProdutoInvalida01() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
