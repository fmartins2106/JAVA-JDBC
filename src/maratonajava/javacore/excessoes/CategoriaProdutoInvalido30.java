package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido30 extends IllegalArgumentException {
    public CategoriaProdutoInvalido30() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
