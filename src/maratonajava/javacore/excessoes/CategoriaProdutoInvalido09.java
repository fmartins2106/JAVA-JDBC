package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido09 extends IllegalArgumentException{
    public CategoriaProdutoInvalido09() {
        super(String.format("Campo categoria não pode ser vazio ou conter caracteres."));
    }
}
