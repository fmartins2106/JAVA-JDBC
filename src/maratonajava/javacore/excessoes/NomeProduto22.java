package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto22 extends IllegalArgumentException {
    public NomeProduto22() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
