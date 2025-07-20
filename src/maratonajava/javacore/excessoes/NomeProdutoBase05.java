package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase05 extends IllegalArgumentException {
    public NomeProdutoBase05() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
