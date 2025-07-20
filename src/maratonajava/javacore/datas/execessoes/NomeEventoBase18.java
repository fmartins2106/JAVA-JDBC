package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase18 extends IllegalArgumentException {
    public NomeEventoBase18() {
        super("Campo nome do evento não pode ser vazio ou conter caracteres.");
    }
}
