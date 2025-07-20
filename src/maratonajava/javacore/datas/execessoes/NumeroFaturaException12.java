package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException12 extends IllegalArgumentException {
    public NumeroFaturaException12() {
        super("Número da fatura não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
