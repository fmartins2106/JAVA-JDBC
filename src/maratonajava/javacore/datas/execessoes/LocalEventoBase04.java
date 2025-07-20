package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class LocalEventoBase04 extends IllegalArgumentException{

    public LocalEventoBase04() {
        super("Campo local não pode ficar vazio ou conter caracteres.");
    }
}
