package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase11 extends IllegalArgumentException {
    public NomeProdutoBase11() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
