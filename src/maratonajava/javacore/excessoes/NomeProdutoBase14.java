package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase14 extends IllegalArgumentException {
    public NomeProdutoBase14() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
