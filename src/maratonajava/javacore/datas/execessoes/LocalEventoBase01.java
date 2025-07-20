package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class LocalEventoBase01 extends IllegalArgumentException {
    public LocalEventoBase01() {
        super("Campo local não pode ser vazio ou conter caracteres.");
    }
}
