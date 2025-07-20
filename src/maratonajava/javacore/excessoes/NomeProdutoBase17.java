package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase17 extends IllegalArgumentException {
    public NomeProdutoBase17() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
