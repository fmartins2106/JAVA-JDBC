package academy.devdojo.maratonajava.javacore.excessoes;

public class AlunoMatriculaInvalida33 extends IllegalArgumentException {
    public static final int MENOR_NUMERO_MATRICULA = 1;
    public AlunoMatriculaInvalida33() {
        super(String.format("Matrícula inválida. Número de matrícula não pode ser menor que %d.",MENOR_NUMERO_MATRICULA));
    }
}
