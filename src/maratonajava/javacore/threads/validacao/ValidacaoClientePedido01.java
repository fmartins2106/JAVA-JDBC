package academy.devdojo.maratonajava.javacore.threads.validacao;

public class ValidacaoClientePedido01 extends IllegalArgumentException {
    public ValidacaoClientePedido01() {
        super("Campo cliente é obrigatório. Não pode conter números ou caracteres.");
    }
}
