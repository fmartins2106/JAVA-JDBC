package academy.devdojo.maratonajava.javacore.excessoes;

public class ProfessorDisciplinaInvalida32 extends IllegalArgumentException{

    public ProfessorDisciplinaInvalida32() {
        super("Campo disciplina não pode ficar vazio ou conter caracteres.");
    }
}
