package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException20 extends IllegalArgumentException {
    public NumeroFaturaException20() {
        super("Número de fatura inválida. Caracteres permitidos:\"/._-\"");
    }
}
