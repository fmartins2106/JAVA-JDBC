package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase01 extends IllegalArgumentException {
    public NomeEventoBase01() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
