package academy.devdojo.maratonajava.javacore.excessoes;

public class ClienteNome39 extends IllegalArgumentException {
    public ClienteNome39() {
        super("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres.");
    }
}
