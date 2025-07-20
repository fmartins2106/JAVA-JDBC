package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException23 extends IllegalArgumentException {
    public NumeroFaturaException23() {
        super("Número da fatura não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
