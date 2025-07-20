
package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException32 extends IllegalArgumentException {
    public NumeroFaturaException32() {
        super("Campo número fatura não pode ser vazio. Caracteres permitidos:\"/_.- \"");
    }
}

