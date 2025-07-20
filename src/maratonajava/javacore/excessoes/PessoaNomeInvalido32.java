package academy.devdojo.maratonajava.javacore.excessoes;

public class PessoaNomeInvalido32 extends IllegalArgumentException {

    public PessoaNomeInvalido32(){
        super("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres.");
    }
}
