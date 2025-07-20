package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto36 extends IllegalArgumentException {
    public NomeProduto36() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
