package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException24 extends IllegalArgumentException {
    public NumeroFaturaException24() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
