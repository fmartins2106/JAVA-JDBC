package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class DataVencimentoFaturaException27 extends IllegalArgumentException {
    public DataVencimentoFaturaException27() {
        super("Data de vencimento inválida. Data deve estar no formato DD/MM/AAAA.");
    }
}
