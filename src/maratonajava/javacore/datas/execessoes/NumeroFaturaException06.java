package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException06 extends IllegalArgumentException {
    public NumeroFaturaException06() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos: /_-.");
    }
}
