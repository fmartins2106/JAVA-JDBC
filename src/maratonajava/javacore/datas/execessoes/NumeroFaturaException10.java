package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException10 extends IllegalArgumentException {
    public NumeroFaturaException10() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos:/_.-");
    }
}
