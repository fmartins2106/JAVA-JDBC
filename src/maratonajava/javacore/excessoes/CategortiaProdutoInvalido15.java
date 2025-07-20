package academy.devdojo.maratonajava.javacore.excessoes;

public class CategortiaProdutoInvalido15 extends IllegalArgumentException {
    public CategortiaProdutoInvalido15() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
