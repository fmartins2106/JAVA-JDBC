package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeDadosProduto extends IllegalArgumentException {
    public NomeDadosProduto() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
