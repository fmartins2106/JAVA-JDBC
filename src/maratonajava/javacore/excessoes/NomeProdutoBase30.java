package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase30 extends IllegalArgumentException {
    public NomeProdutoBase30() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
