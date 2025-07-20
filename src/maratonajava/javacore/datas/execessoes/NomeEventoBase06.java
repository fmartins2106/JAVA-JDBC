package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase06 extends IllegalArgumentException {
    public NomeEventoBase06() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
