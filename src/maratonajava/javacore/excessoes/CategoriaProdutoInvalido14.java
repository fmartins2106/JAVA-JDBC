package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido14 extends IllegalArgumentException {
    public CategoriaProdutoInvalido14() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
