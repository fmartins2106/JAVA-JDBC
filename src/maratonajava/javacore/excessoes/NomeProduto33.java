package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto33 extends IllegalArgumentException {
    public NomeProduto33() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
