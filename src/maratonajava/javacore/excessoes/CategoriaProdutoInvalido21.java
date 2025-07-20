package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido21 extends IllegalArgumentException {
    public CategoriaProdutoInvalido21() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
