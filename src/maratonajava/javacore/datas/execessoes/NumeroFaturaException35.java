package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException35 extends IllegalArgumentException {
    public NumeroFaturaException35() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}
