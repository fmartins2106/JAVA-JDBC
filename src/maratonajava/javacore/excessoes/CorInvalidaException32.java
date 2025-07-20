package academy.devdojo.maratonajava.javacore.excessoes;

public class CorInvalidaException32 extends IllegalArgumentException {
    public CorInvalidaException32() {
        super("Campo cor não pode ser vazio ou conter caracteres.");
    }
}
