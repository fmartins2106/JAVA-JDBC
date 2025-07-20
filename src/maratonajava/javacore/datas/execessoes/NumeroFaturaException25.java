package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException25 extends IllegalArgumentException {
    public NumeroFaturaException25() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
