package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException02 extends IllegalArgumentException {
    public NumeroFaturaException02() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos: /.-_");
    }
}
