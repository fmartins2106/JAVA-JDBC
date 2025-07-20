
package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException31 extends IllegalArgumentException {
    public NumeroFaturaException31() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos \"/._-\"");
    }
}

