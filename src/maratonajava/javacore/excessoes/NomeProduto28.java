package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto28 extends IllegalArgumentException {
    public NomeProduto28() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
