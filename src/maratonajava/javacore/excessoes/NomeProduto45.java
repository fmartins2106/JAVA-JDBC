package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto45 extends IllegalArgumentException {
    public NomeProduto45() {
        super("Campo nome produto não pode ser vazio. Caracteres não são permitidos.");
    }
}
