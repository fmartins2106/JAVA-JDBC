package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido10 extends IllegalArgumentException {
    public CategoriaProdutoInvalido10() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
