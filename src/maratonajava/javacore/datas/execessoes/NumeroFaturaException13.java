package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException13 extends IllegalArgumentException {
    public NumeroFaturaException13() {
        super("Número de fatura inválida. Caracteres aceitos: \"/_-.\"");
    }
}
