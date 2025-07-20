package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase18 extends IllegalArgumentException {
    public NomeProdutoBase18() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
