package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase02 extends IllegalArgumentException {
    public NomeProdutoBase02() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
