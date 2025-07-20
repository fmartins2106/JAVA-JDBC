package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException28 extends IllegalArgumentException {
    public NumeroFaturaException28() {
        super("Campo número não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
