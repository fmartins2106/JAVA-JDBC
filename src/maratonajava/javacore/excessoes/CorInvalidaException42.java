package academy.devdojo.maratonajava.javacore.excessoes;

public class CorInvalidaException42 extends IllegalArgumentException {
    public CorInvalidaException42() {
        super("Campo cor não pode ser vazio ou conter caracteres.");
    }
}
