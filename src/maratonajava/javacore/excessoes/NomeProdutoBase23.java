package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase23 extends IllegalArgumentException {
    public NomeProdutoBase23() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
