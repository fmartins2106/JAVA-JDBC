package academy.devdojo.maratonajava.javacore.excessoes;

public class NomeProduto29 extends IllegalArgumentException {
    public NomeProduto29() {
        super("Campo nome do produto não pode fica vazio ou contar caracteres.");
    }
}
