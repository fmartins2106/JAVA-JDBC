package academy.devdojo.maratonajava.javacore.excessoes;

public class ProfessorSalarioInvalido34 extends IllegalArgumentException {
    public static final double SALARIO_MINIMO_PROFESSOR = 0;
    public ProfessorSalarioInvalido34() {
        super(String.format("Salário de profesor não pode ser menor que R$%.2f",SALARIO_MINIMO_PROFESSOR));
    }
}
