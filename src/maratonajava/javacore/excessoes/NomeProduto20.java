package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto20 extends IllegalArgumentException {
    public NomeProduto20() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
