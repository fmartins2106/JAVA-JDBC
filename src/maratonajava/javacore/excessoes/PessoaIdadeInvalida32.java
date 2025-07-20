package academy.devdojo.maratonajava.javacore.excessoes;

public class PessoaIdadeInvalida32 extends IllegalArgumentException {
    public static final int IDADE_MINIMA = 6;

    public PessoaIdadeInvalida32() {
        super(String.format("Idade mínima para se matricular na escola é %d.",IDADE_MINIMA));
    }
}
