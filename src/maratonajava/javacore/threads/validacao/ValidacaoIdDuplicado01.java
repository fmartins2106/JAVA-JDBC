package academy.devdojo.maratonajava.javacore.threads.validacao;

public class ValidacaoIdDuplicado01 extends IllegalArgumentException {
    public ValidacaoIdDuplicado01() {
        super("ID Já cadastrado no sistema. Verifique.");
    }
}
