package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase03 extends IllegalArgumentException {
    public NomeEventoBase03() {
        super("Campo nome não pode ser vazio ou conter caracteres.");
    }
}
