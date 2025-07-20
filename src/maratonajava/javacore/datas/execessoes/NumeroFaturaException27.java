package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException27 extends IllegalArgumentException {
    public NumeroFaturaException27() {
        super("Número da fatura não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
