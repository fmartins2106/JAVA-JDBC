package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase12 extends IllegalArgumentException {
    public NomeProdutoBase12() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
