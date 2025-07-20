package academy.devdojo.maratonajava.javacore.excessoes;

public class ProfessorSalarioInvalido33 extends IllegalArgumentException {
    public static final double SALARIO_MINIMO = 3500;
    public ProfessorSalarioInvalido33() {
      super(String.format("Salário de professor não pode ser menor que R$%.2f.",SALARIO_MINIMO));
    }
}
