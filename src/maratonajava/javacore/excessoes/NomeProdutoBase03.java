package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase03 extends IllegalArgumentException {
    public NomeProdutoBase03() {
        super("Campo nome não pode ficar vazio ou conter catacteres.");
    }
}
