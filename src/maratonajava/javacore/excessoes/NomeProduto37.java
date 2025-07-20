package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto37 extends IllegalArgumentException {
    public NomeProduto37() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
