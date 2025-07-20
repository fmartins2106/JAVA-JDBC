
package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase31 extends IllegalArgumentException {
    public NomeProdutoBase31() {
        super("Campo nome produto não pode ser vazio ou conter caracteres.");
    }
}

