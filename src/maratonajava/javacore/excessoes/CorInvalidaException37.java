package academy.devdojo.maratonajava.javacore.excessoes;

import java.util.IllformedLocaleException;

public class CorInvalidaException37 extends IllformedLocaleException {
    public CorInvalidaException37() {
        super("Campo cor não pode ser vazio ou conter caracteres.");
    }
}
