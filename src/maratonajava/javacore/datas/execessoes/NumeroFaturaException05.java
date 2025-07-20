package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException05 extends IllegalArgumentException {
    public NumeroFaturaException05() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos /_-.");
    }
}
