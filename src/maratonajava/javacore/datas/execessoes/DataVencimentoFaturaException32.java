
package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class DataVencimentoFaturaException32 extends IllegalArgumentException {
    public DataVencimentoFaturaException32() {
        super("Data vencimento invpálido. Digite uma data no formato DD/MM/AAAA");
    }
}

