package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase05 extends IllegalArgumentException {
    public NomeEventoBase05() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
