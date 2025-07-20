package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeCliente42 extends IllegalArgumentException {
    public NomeCliente42() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
