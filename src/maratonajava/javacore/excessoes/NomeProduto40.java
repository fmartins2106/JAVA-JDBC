package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto40 extends IllegalArgumentException {
    public NomeProduto40() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
