package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProdutoBase01 extends IllegalArgumentException{
    public NomeProdutoBase01() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
