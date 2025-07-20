package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto35 extends IllegalArgumentException {
    public NomeProduto35() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
