package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase09 extends IllegalArgumentException {
    public NomeProdutoBase09() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
