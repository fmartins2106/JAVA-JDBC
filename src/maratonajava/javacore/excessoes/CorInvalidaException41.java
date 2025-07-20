package academy.devdojo.maratonajava.javacore.excessoes;

public class CorInvalidaException41 extends IllegalArgumentException {
    public CorInvalidaException41() {
        super("Campo cor não pode ser vazio ou conter caracteres.");
    }
}
