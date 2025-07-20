package academy.devdojo.maratonajava.javacore.excessoes;

public class PessoaNomeInvalido33 extends IllegalArgumentException {
    public PessoaNomeInvalido33() {
        super("Campo nome não pode ser vazio ou conter caracteres. Digite nome completo.");
    }
}
