package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeCliente41 extends IllegalArgumentException {
    public NomeCliente41() {
        super("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres.");
    }
}
