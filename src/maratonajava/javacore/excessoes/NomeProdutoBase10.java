package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase10 extends IllegalArgumentException {
    public NomeProdutoBase10() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
