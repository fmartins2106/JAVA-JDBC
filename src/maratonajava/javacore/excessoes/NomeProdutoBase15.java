package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase15 extends IllegalArgumentException {
    public NomeProdutoBase15() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
