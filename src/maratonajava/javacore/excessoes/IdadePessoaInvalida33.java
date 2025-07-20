package academy.devdojo.maratonajava.javacore.excessoes;

public class IdadePessoaInvalida33 extends IllegalArgumentException{
    public static final int MENOR_IDADE = 6;
    public IdadePessoaInvalida33() {
        super(String.format("Idade não pode ser menor que %d.",MENOR_IDADE));
    }
}
