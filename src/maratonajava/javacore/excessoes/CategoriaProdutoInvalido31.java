
package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido31 extends IllegalArgumentException {
    public CategoriaProdutoInvalido31() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}

