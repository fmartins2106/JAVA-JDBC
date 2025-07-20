package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase10 extends IllegalArgumentException {
    public NomeEventoBase10() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
