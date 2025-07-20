package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException21 extends IllegalArgumentException {
    public NumeroFaturaException21() {
        super("Número de fatura inválido. Caracteres permitidos:\"/._-\"");
    }
}
