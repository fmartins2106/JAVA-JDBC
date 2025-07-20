package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto34 extends IllegalArgumentException {
    public NomeProduto34() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
