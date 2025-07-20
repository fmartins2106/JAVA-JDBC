package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException14 extends IllegalArgumentException {
    public NumeroFaturaException14() {
        super("Número de fatura inválida. Caracteres permitidos:\"/._-\"");
    }
}
