package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto31 extends IllegalArgumentException {
    public NomeProduto31() {
        super("Nome do produto não pode ser vazio ou conter caracteres.");
    }
}
