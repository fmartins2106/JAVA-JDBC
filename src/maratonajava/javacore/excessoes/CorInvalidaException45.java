package academy.devdojo.maratonajava.javacore.excessoes;

public class CorInvalidaException45 extends IllegalArgumentException {
    public CorInvalidaException45() {
        super("Campo cor não pode ser vazio ou conter caracteres.");
    }
}
