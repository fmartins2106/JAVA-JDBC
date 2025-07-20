package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException08 extends IllegalArgumentException {
    public NumeroFaturaException08() {
        super("Campo nome fatura não pode ser vazio. Caracteres permitidos:/_-.");
    }
}
