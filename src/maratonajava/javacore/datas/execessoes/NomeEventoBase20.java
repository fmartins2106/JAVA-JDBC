package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase20 extends IllegalArgumentException {
    public NomeEventoBase20() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
