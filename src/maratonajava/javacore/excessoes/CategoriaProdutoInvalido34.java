package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido34 extends IllegalArgumentException {
    public CategoriaProdutoInvalido34() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
