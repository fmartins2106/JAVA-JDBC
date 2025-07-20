package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto21 extends IllegalArgumentException {
    public NomeProduto21() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
