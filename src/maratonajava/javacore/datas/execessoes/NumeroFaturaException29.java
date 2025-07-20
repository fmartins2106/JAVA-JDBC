package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException29 extends IllegalArgumentException {
    public NumeroFaturaException29() {
        super("Número de fatura inválida. Caracteres válidos:\"/._-\"");
    }
}
