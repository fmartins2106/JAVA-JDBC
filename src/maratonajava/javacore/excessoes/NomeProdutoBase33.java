package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase33 extends IllegalArgumentException {
    public NomeProdutoBase33() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
