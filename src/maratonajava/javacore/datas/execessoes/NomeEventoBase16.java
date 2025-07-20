package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase16 extends IllegalArgumentException {
    public NomeEventoBase16() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
