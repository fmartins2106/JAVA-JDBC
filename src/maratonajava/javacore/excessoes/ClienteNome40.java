package academy.devdojo.maratonajava.javacore.excessoes;

public class ClienteNome40 extends IllegalArgumentException {
    public ClienteNome40() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
