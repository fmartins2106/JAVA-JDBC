package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase20 extends IllegalArgumentException {
    public NomeProdutoBase20() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
