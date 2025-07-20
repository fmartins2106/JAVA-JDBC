package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase09 extends IllegalArgumentException {
    public NomeEventoBase09() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
