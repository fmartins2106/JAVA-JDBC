package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase30 extends IllegalArgumentException {
    public NomeEventoBase30() {
        super("Campo nome evento não pode ser vazio ou conter caracteres.");
    }
}
