package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase28 extends IllegalArgumentException {
    public NomeProdutoBase28() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
