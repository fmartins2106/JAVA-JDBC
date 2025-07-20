package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase32 extends IllegalArgumentException {
    public NomeEventoBase32() {
        super("Campo nome evento não pode ser vazio ou conter caracteres.");
    }
}
