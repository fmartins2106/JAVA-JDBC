package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto25 extends IllegalArgumentException {
    public NomeProduto25() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
