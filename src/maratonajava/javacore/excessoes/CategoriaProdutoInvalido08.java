package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido08 extends IllegalArgumentException {
    public CategoriaProdutoInvalido08() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
