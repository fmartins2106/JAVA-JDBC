package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase02 extends IllegalArgumentException {
    public NomeEventoBase02() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
