package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class DataVencimentoFaturaException30 extends IllegalArgumentException {
    public DataVencimentoFaturaException30() {
        super("Campo data vencimento não pode ser vazio ou conter caracteres.");
    }
}
