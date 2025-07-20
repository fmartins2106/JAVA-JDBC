package academy.devdojo.maratonajava.javacore.excessoes;

public class NomePessoaInvalido34 extends IllegalArgumentException {
    public NomePessoaInvalido34() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
