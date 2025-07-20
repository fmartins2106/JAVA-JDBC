package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto32 extends IllegalArgumentException {
    public NomeProduto32() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
