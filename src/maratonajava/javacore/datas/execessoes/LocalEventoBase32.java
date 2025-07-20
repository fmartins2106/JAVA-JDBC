package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class LocalEventoBase32 extends IllegalArgumentException {
    public LocalEventoBase32() {
        super("Campo local evento não pode ser vazio ou conter caracteres.");
    }
}
