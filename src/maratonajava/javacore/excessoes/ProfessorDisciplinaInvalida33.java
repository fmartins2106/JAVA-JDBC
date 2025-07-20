package academy.devdojo.maratonajava.javacore.excessoes;

public class ProfessorDisciplinaInvalida33 extends IllegalArgumentException {
    public ProfessorDisciplinaInvalida33() {
        super("Campo disciplina não pode ficar vazio ou conter caracteres.");
    }
}
