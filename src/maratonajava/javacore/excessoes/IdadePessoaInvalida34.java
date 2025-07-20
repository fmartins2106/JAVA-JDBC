package academy.devdojo.maratonajava.javacore.excessoes;

public class IdadePessoaInvalida34 extends IllegalArgumentException {
    public static final int MENOR_IDADE = 6;
    public IdadePessoaInvalida34() {
        super(String.format("Idade não pode ser menor que %d.",MENOR_IDADE));
    }
}
