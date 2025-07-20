package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase21 extends IllegalArgumentException {
    public NomeProdutoBase21() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
