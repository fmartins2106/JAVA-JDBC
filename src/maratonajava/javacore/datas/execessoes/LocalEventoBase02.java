package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class LocalEventoBase02 extends IllegalArgumentException{
    public LocalEventoBase02() {
        super("Campo local não pode ser vazio ou conter caracteres.");
    }
}
