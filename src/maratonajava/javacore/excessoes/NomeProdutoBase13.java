package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase13 extends IllegalArgumentException {
    public NomeProdutoBase13() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
