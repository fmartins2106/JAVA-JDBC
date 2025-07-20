package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class NumeroFaturaException01 extends IllegalArgumentException {
    public NumeroFaturaException01() {
        super("Campo fatura não pode ser vazio ou conter caracteres diferentes de /._-");
    }
}
