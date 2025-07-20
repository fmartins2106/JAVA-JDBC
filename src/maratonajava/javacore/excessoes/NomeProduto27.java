package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto27 extends IllegalArgumentException {
    public NomeProduto27() {
        super("Campo nome do produto não pode ser vazio ou conter caracteres.");
    }
}
