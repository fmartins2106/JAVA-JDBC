package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException30 extends IllegalArgumentException {
    public NumeroFaturaException30() {
        super("Número de fatura inválida. Caracteres permitidos:\"/._- \"");
    }
}
