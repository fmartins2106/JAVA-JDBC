package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto44 extends IllegalArgumentException {
    public NomeProduto44() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}
