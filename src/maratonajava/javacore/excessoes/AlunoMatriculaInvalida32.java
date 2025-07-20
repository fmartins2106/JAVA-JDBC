package academy.devdojo.maratonajava.javacore.excessoes;

public class AlunoMatriculaInvalida32 extends IllegalArgumentException{
    public static final  int MENOR_MATRICULA = 1;

    public AlunoMatriculaInvalida32() {
        super(String.format("Matrícula não pode ser menor que %d.",MENOR_MATRICULA));
    }
}
