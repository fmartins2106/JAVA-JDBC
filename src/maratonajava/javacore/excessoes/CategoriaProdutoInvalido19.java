package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido19 extends IllegalArgumentException {
    public CategoriaProdutoInvalido19() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
