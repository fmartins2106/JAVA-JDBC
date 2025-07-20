package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase26 extends IllegalArgumentException {
    public NomeProdutoBase26() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
