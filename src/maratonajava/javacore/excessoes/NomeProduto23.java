package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto23 extends IllegalArgumentException {
    public NomeProduto23() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
