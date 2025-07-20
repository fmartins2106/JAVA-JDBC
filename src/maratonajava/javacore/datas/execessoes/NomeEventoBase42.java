
package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NomeEventoBase42 extends IllegalArgumentException {
    public NomeEventoBase42() {
        super("Campo nome evento não pode ser vazio ou conter caracteres.");
    }
}

