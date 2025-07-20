package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException18 extends IllegalArgumentException {
    public NumeroFaturaException18() {
        super("Campo numero não pode ser vazio. Caracteres permitidos:\"/_.-\"");
    }
}
