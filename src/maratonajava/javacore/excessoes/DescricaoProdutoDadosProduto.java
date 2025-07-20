package academy.devdojo.maratonajava.javacore.excessoes;

public class DescricaoProdutoDadosProduto extends IllegalArgumentException {
    public DescricaoProdutoDadosProduto() {
        super("Campo descrição não pode ser vazio ou conter caracteres.");
    }
}
