package academy.devdojo.maratonajava.javacore.excessoes;

public class AlunoNotasInvalidas32 extends IllegalArgumentException{
    public static final double MENOR_NOTA = 0;
    public static final double MAIOR_NOTA = 10;

    public AlunoNotasInvalidas32() {
        super(String.format("Nota não pode ser menor que %.2f ou maior que %.2f.",MENOR_NOTA,MAIOR_NOTA));
    }
}
