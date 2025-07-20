package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto42 extends IllegalArgumentException {
    public NomeProduto42() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
