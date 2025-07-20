package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase04 extends IllegalArgumentException {
    public NomeProdutoBase04() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
