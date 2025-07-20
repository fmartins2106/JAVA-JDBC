package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase29 extends IllegalArgumentException {
    public NomeProdutoBase29() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
