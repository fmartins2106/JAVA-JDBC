package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase07 extends IllegalArgumentException {
    public NomeEventoBase07() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
