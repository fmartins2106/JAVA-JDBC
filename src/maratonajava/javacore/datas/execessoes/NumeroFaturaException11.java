package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException11 extends IllegalArgumentException {
    public NumeroFaturaException11() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos: \"/_.-\"");
    }
}
