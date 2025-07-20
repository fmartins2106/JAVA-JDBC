package academy.devdojo.maratonajava.javacore.threads.validacao;

public class ValidacaoIdPedido01 extends IllegalArgumentException {
    public static final int ID_MINIMO = 0;
    public ValidacaoIdPedido01() {
        super(String.format("ID não pode ser menor que %d.",ID_MINIMO));
    }
}
