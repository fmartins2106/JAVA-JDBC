package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException03 extends IllegalArgumentException {
    public NumeroFaturaException03() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos: /.-_");
    }
}
