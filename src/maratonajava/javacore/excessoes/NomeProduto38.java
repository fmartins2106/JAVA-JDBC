package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto38 extends IllegalArgumentException {
    public NomeProduto38() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
