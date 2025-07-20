package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase08 extends IllegalArgumentException {
    public NomeProdutoBase08() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
