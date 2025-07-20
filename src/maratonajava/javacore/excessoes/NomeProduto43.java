package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto43 extends IllegalArgumentException {
    public NomeProduto43() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
