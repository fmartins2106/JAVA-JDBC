package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto24 extends IllegalArgumentException {
    public NomeProduto24() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
