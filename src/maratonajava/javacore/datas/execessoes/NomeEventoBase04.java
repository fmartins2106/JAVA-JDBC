package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase04 extends IllegalArgumentException {
    public NomeEventoBase04() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
