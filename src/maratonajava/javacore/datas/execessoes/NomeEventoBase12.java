package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase12 extends IllegalArgumentException {
    public NomeEventoBase12() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
