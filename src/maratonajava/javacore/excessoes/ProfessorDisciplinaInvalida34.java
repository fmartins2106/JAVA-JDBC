package academy.devdojo.maratonajava.javacore.excessoes;

public class ProfessorDisciplinaInvalida34 extends IllegalArgumentException {
    public ProfessorDisciplinaInvalida34() {
        super("Campo disciplina não pode ser vazio ou conter caracteres.");
    }
}
