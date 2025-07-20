package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException15 extends IllegalArgumentException {
    public NumeroFaturaException15() {
        super("Número de fatura inválido. Caracteres permitidos:\"/_.-\"");
    }
}
