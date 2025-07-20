package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto39 extends IllegalArgumentException {
    public NomeProduto39() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
