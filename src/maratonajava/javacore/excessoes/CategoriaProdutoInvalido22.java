package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido22 extends IllegalArgumentException {
    public CategoriaProdutoInvalido22() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
