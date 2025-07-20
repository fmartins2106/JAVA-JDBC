package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class LocalEventoBase03 extends IllegalArgumentException {
    public LocalEventoBase03() {
        super("Campo local não pode ser vazio ou conter caracteres.");
    }
}
