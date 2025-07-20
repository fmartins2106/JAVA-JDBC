package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto30 extends IllegalArgumentException {
    public NomeProduto30() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
