package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase06 extends IllegalArgumentException {
    public NomeProdutoBase06() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
