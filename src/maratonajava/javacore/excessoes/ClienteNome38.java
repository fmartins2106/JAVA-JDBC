package academy.devdojo.maratonajava.javacore.excessoes;

public class ClienteNome38 extends IllegalArgumentException {
    public ClienteNome38() {
      super("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres.");
    }
}
