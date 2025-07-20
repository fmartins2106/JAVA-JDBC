package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase26 extends IllegalArgumentException {
    public NomeEventoBase26() {
        super("Campo nome evento não pode ser vazio ou conter caracteres.");
    }
}
