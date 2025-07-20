package academy.devdojo.maratonajava.javacore.excessoes;

public class AlunoMatriculaInvalida34 extends IllegalArgumentException {
    public static final int MENOR_MATRICULA = 1;
    public AlunoMatriculaInvalida34() {
        super(String.format("Matrícula não pode ser menor que %d.",MENOR_MATRICULA));
    }
}
