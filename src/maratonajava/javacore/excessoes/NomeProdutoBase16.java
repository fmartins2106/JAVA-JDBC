package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase16 extends IllegalArgumentException {
    public NomeProdutoBase16() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
