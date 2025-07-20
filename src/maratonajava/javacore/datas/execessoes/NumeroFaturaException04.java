package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException04 extends IllegalArgumentException {
    public NumeroFaturaException04() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos /._-");
    }
}
