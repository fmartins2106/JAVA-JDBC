package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase19 extends IllegalArgumentException {
    public NomeProdutoBase19() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
