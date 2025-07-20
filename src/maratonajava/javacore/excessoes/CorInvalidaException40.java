package academy.devdojo.maratonajava.javacore.excessoes;

public class CorInvalidaException40 extends IllegalArgumentException {
    public CorInvalidaException40() {
        super("Campo cor não pode ser vazio ou conter caracteres.");
    }
}
