package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException16 extends IllegalArgumentException {
    public NumeroFaturaException16() {
        super("Número de fatura inválido. Caracteres permitidos:\"/._-\"");
    }
}
