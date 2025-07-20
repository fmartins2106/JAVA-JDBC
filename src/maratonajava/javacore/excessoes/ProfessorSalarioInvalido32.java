package academy.devdojo.maratonajava.javacore.excessoes;

public class ProfessorSalarioInvalido32 extends RuntimeException {
    public static final double MENOR_SALARIO = 3500;

    public ProfessorSalarioInvalido32() {
      super(String.format("Salário não pode ser menor que R$%.2f.",MENOR_SALARIO));
    }
}
