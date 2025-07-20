package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase27 extends IllegalArgumentException {
    public NomeProdutoBase27() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
