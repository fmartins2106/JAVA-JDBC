package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase32 extends IllegalArgumentException {
    public NomeProdutoBase32() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
