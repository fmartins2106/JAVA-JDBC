package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto26 extends IllegalArgumentException {
    public NomeProduto26() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
