package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase25 extends IllegalArgumentException {
    public NomeProdutoBase25() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
