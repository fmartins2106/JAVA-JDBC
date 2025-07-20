package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class LocalEventoBase05 extends IllegalArgumentException {
    public LocalEventoBase05() {
        super("Campo local não pode ser vazio ou conter caracteres.");
    }
}
