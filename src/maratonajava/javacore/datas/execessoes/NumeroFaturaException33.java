
package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException33 extends IllegalArgumentException {
    public NumeroFaturaException33() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos:\"/._-\"");
    }
}

