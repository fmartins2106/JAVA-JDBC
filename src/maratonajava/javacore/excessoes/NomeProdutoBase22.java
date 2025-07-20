package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase22 extends IllegalArgumentException {
    public NomeProdutoBase22() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
