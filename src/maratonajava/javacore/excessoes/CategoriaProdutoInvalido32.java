package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido32 extends IllegalArgumentException {
    public CategoriaProdutoInvalido32() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
