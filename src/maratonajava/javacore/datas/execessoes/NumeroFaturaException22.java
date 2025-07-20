package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException22 extends IllegalArgumentException {
    public NumeroFaturaException22() {
    super("Número de fatura inválida. Caracteres permitidos:\"/._-\"");
    }
}
