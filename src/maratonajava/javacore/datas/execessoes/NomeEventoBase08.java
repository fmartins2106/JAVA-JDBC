package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase08 extends IllegalArgumentException{
    public NomeEventoBase08() {
        super("Campo nome não pode ficar vazio ou conter caracteres.");
    }
}
