package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase07 extends IllegalArgumentException {
    public NomeProdutoBase07() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
