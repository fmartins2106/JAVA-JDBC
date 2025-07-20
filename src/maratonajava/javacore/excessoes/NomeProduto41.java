package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto41 extends IllegalArgumentException {
    public NomeProduto41() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
