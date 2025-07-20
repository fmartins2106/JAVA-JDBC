package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase34 extends IllegalArgumentException {
    public NomeProdutoBase34() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
